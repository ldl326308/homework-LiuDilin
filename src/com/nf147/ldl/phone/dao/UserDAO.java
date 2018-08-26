package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.User;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements User_DAO<User> {
    @Override
    public List<User> listAll() {
        String sql = "select * from `user`";
        ResultSet rs = DBUtil.executeQuery(sql);
        User user = null;
        List<User> list = new ArrayList<User>();
        try {
            while (rs.next()) {
                user  = new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")
                );
                list.add(user);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public User getById(int u_id) {
        String sql = "select * from `user` where `u_id` = ? ";
        Object[] in = new Object[]{u_id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        User user = null;
        try {
            while (rs.next()) {
                user  = new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")
                );
            }
        }catch (Exception e){
            e.getMessage();
        }

        return user;
    }

    @Override
    public List<User> getByName(String user_name){
        String sql = "select * from `user` where `user_name` like '%"+user_name+"%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        User user = null;
        List<User> list = new ArrayList<User>();
        try {
            while (rs.next()) {
                user = new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")
                );
                list.add(user);
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return list;
    }

    @Override
    public boolean update(User user) {
        //修改操作
        String sql ="update `user` set `user_id`= ? ,`user_name` = ?,`user_pwd`= ? where `u_id`= ? ;";
        Object[] in = new Object[]{user.getUser_id(),user.getUser_name(),user.getUser_pwd(),user.getU_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int u_id) {
        String sql = "delete from `user` where `u_id` = ?";
        Object[] in = new Object[]{u_id};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }


    @Override
    public boolean add(User user) {
        String sql = "insert into `user`(user_id,user_name,user_pwd) values(?,?,?)";
        Object[] in = new Object[]{user.getUser_id(),user.getUser_name(),user.getUser_pwd()};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }


    public List<User> getLikeQuery(String trem){
        String sql = "select * from `user` where `user_id` like '%"+trem+"%' or `user_name` like '%"+trem+"%' ;";
        ResultSet rs = DBUtil.executeQuery(sql);
        User user = null;
        List<User> list = new ArrayList<User>();
        try {
            while (rs.next()) {
                user = new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_pwd")
                );
                list.add(user);
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return list;
    }



}
