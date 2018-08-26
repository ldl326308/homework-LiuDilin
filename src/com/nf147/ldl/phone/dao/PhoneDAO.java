package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Phone;
import utils.DBUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAO implements Phone_DAO<Phone> {
    @Override
    public List<Phone> listAll() {
        String sql = "select * from `phone`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Phone phone = null;
        List<Phone> list = new ArrayList<Phone>();
        try {
            while (rs.next()) {
                phone  = new Phone(
                       rs.getInt("phone_id"),
                        rs.getBigDecimal("phone_price"),
                        rs.getInt("phone_state"),
                        rs.getString("phone_supplier"),
                        rs.getString("phone_describe")
                );
                list.add(phone);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Phone getById(int phone_id) {
        String sql = "select * from `phone` where `phone_id` = ? ";
        Object[] in = new Object[]{phone_id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Phone phone = null;
        try {
            while (rs.next()) {
                phone  = new Phone(
                        rs.getInt("phone_id"),
                        rs.getBigDecimal("phone_price"),
                        rs.getInt("phone_state"),
                        rs.getString("phone_supplier"),
                        rs.getString("phone_describe")
                );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return phone;
    }

    @Override
    public List<Phone> getByName(String type_name) {
        //select * from `phone` p inner join `type` t on p.phone_id=t.t_id where t.type_name like '%诺基亚%';
        return null;
    }

    @Override
    public boolean update(Phone model) {
        String sql ="update `phone` set `phone_price` = ?,`phone_state`=?,`phone_supplier`=?,`phone_describe`=? where `phone_id`= ?";
        Object[] in = new Object[]{model.getPhone_price(),model.getPhone_state(),model.getPhone_supplier(),model.getPhone_describe(),model.getPhone_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int phone_id) {
        String sql = "delete from `phone` where `phone_id` = ?";
        Object[] in = new Object[]{phone_id};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Phone model) {
        String sql = "insert into `phone`(`phone_id`,`phone_price` ,`phone_state` ,`phone_supplier`,`phone_describe` ) values(?,?,?,?,?)";
        Object[] in = new Object[]{model.getPhone_id(),model.getPhone_price(),model.getPhone_state(),model.getPhone_supplier(),model.getPhone_describe()};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

}
