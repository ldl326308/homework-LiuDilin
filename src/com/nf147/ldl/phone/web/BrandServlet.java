package com.nf147.ldl.phone.web;

import com.google.gson.Gson;
import com.nf147.ldl.phone.dao.BrandDAO;
import com.nf147.ldl.phone.dao.Brand_DAO;
import com.nf147.ldl.phone.entity.Brand;
import utils.DBUtilSetEncoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BrandServlet")
public class BrandServlet extends HttpServlet {

    Brand_DAO dao = new BrandDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilSetEncoding.setEncoding(req, resp); //设置编码
        String action = req.getParameter("action");

        if (action.equals("query")) {   //数据查询
            boolean bool = req.getParameter("term").equals("term");
            if (bool) {
                resp.getWriter().print(new Gson().toJson(dao.listAll()));   // json 数据返回
            } else {
                resp.getWriter().print(new Gson().toJson(new BrandDAO().getByName(req.getParameter("term"))));
            }
        } else if (action.equals("del")) {  //删除单个
            int b_id = Integer.parseInt(req.getParameter("b_id"));
            if (dao.delete(b_id)) {  //删除成功
                resp.getWriter().print("{\"msg\":\"删除成功！\"}");
            } else {  //删除失败
                resp.getWriter().print("{\"msg\":\"删除失败！\"}");
            }
        } else if (action.equals("add")) {
            String brand_name = req.getParameter("brand_name");
            String brand_id = req.getParameter("brand_id");

            if (dao.add(new Brand(brand_id, brand_name))) {
                resp.getWriter().print("{\"msg\":\"添加成功！\"}");
            } else {
                resp.getWriter().print("{\"msg\":\"添加失败！\"}");
            }
        } else if (action.equals("infoBrand")) {
            Brand user = (Brand) dao.getById(Integer.parseInt(req.getParameter("b_id")));
            resp.getWriter().print(new Gson().toJson(user));
        } else if (action.equals("brandUpd")) {
            int b_id = Integer.parseInt(req.getParameter("b_id"));
            String brand_id = req.getParameter("brand_id");
            String brand_name = req.getParameter("brand_name");

            if (dao.update(new Brand(b_id, brand_id, brand_name))) {
                resp.getWriter().print("{\"msg\":\"修改成功！\"}");
            } else {
                resp.getWriter().print("{\"msg\":\"修改失败！\"}");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilSetEncoding.setEncoding(req,resp); //设置编码
        String[] b_ids = req.getParameterValues("b_id");
        for (int i = 0; i < b_ids.length; i++) {
            dao.delete(Integer.parseInt(b_ids[i]));
        }
        //重定向
        resp.sendRedirect("brand_show.jsp");
    }
}
