package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Purchase;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO implements Purchase_DAO<Purchase> {
    @Override
    public List<Purchase> listAll() {
        String sql = "select * from `purchase`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Purchase purchase = null;
        List<Purchase> list = new ArrayList<Purchase>();
        try {
            while (rs.next()) {
                purchase  = new Purchase(
                        rs.getInt("purchase_u_id"),
                        rs.getInt("purchase_id"),
                        rs.getInt("purchase_count"),
                        rs.getTime("purchase_time"),
                        rs.getString("purchase_decribe")
                );
                list.add(purchase);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public List<Purchase> getByUserId(int purchase_u_id) {
        String sql = "select * from `purchase` where `purchase_u_id` = ?";
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{purchase_u_id});
        Purchase purchase = null;
        List<Purchase> list = new ArrayList<Purchase>();
        try {
            while (rs.next()) {
                purchase  = new Purchase(
                        rs.getInt("purchase_u_id"),
                        rs.getInt("purchase_id"),
                        rs.getInt("purchase_count"),
                        rs.getTime("purchase_time"),
                        rs.getString("purchase_decribe")
                );
                list.add(purchase);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public List<Purchase> getByPhoneId(int purchase_id) {
        String sql = "select * from `purchase` where `purchase_id` = ?";
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{purchase_id});
        Purchase purchase = null;
        List<Purchase> list = new ArrayList<Purchase>();
        try {
            while (rs.next()) {
                purchase  = new Purchase(
                        rs.getInt("purchase_u_id"),
                        rs.getInt("purchase_id"),
                        rs.getInt("purchase_count"),
                        rs.getTime("purchase_time"),
                        rs.getString("purchase_decribe")
                );
                list.add(purchase);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public boolean update(Purchase model) {
        String sql ="update `purchase` set `purchase_count` = ?,`purchase_decribe`=?,`purchase_u_id`=?,`purchase_id`=? where `purchase_u_id`=? and `purchase_id`=? ";
        Object[] in = new Object[]{model.getPurchase_count(),model.getPurchase_decribe(),model.getPurchase_u_id(),model.getPurchase_id(),model.getPurchase_u_id(),model.getPurchase_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Purchase model) {
        String sql = "delete from `purchase` where `purchase_u_id`=? and `purchase_id`=? and `purchase_decribe`=?";
        Object[] in = new Object[]{model.getPurchase_u_id(),model.getPurchase_id(),model.getPurchase_decribe()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Purchase model) {
        String sql = "insert into `purchase`(`purchase_u_id`,`purchase_id`,`purchase_count`,`purchase_decribe`) values(?,?,?,?)";
        Object[] in = new Object[]{model.getPurchase_u_id(),model.getPurchase_id(),model.getPurchase_count(),model.getPurchase_decribe()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
