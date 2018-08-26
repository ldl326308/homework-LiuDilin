package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Type;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO implements Type_DAO<Type> {
    @Override
    public List<Type> listAll() {
        String sql = "select * from `type`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Type type = null;
        List<Type> list = new ArrayList<Type>();
        try {
            while (rs.next()) {
                type  = new Type(
                        rs.getInt("t_id"),
                        rs.getString("Type_id"),
                        rs.getString("Type_name")
                );
                list.add(type);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Type getById(int id) {
        String sql = "select * from `type` where `t_id` = ? ";
        Object[] in = new Object[]{id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Type type = null;
        try {
            while (rs.next()) {
                type  = new Type(
                        rs.getInt("t_id"),
                        rs.getString("type_id"),
                        rs.getString("type_name")
                );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return type;
    }

    @Override
    public List<Type> getByName(String name) {
        String sql = "select * from `type` where `type_name` like '%"+name+"%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        Type type = null;
        List<Type> list = new ArrayList<Type>();
        try {
            while (rs.next()) {
                type  = new Type(
                        rs.getInt("t_id"),
                        rs.getString("type_id"),
                        rs.getString("type_name")
                );
                list.add(type);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public boolean update(Type model) {
        //修改操作
        String sql ="update `type` set `type_name` = ?,`type_id`=? where `t_id`= ?;";
        Object[] in = new Object[]{model.getType_name(),model.getType_id(),model.getT_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from `type` where `t_id` = ?";
        Object[] in = new Object[]{id};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean add(Type model) {
        String sql = "insert into `type`(type_id,type_name) values(?,?)";
        Object[] in = new Object[]{model.getType_id(),model.getType_name()};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
