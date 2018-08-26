package com.nf147.ldl.phone.web;

import com.google.gson.Gson;
import com.nf147.ldl.phone.dao.UserDAO;
import com.nf147.ldl.phone.dao.User_DAO;
import com.nf147.ldl.phone.entity.User;
import utils.DBUtilSetEncoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    User_DAO dao = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilSetEncoding.setEncoding(req,resp); //设置编码
        String action = req.getParameter("action");

        if(action.equals("query")){   //数据查询
            boolean bool =  req.getParameter("term").equals("term");
            if(bool) {
                resp.getWriter().print(new Gson().toJson(dao.listAll()));   // json 数据返回
            }else{
                resp.getWriter().print(new Gson().toJson(new UserDAO().getLikeQuery(req.getParameter("term"))));
            }
        }
        else if(action.equals("del")){  //删除单个
            int u_id = Integer.parseInt(req.getParameter("u_id"));
            if(dao.delete(u_id)){  //删除成功
                resp.getWriter().print("{\"msg\":\"删除成功！\"}");
            }else{  //删除失败
                resp.getWriter().print("{\"msg\":\"删除失败！\"}");
            }
        }else if(action.equals("add")){
            String user_id = req.getParameter("user_id");
            String user_name = req.getParameter("user_name");
            String user_pwd = req.getParameter("user_pwd");

            if(dao.add(new User(user_id,user_name,user_pwd))){
                resp.getWriter().print("{\"msg\":\"添加成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"添加失败！\"}");
            }
        }else if(action.equals("infoUser")){
            User user = (User) dao.getById(Integer.parseInt(req.getParameter("u_id")));
            resp.getWriter().print(new Gson().toJson(user));
        }else if(action.equals("userUpd")){
            int u_id = Integer.parseInt(req.getParameter("u_id"));
            String user_id = req.getParameter("user_id");
            String user_name = req.getParameter("user_name");
            String user_pwd = req.getParameter("user_pwd");

            if(dao.update(new User(u_id,user_id,user_name,user_pwd))){
                resp.getWriter().print("{\"msg\":\"修改成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"修改失败！\"}");
            }


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilSetEncoding.setEncoding(req,resp); //设置编码
        System.out.println("批量删除");
        String[] u_ids = req.getParameterValues("user_id");
        for (int i = 0; i < u_ids.length; i++) {
            dao.delete(Integer.parseInt(u_ids[i]));
        }
        //重定向
        resp.sendRedirect("user_show.jsp");

    }
}
