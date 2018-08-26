package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Supplier;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements Supplier_DAO<Supplier> {
    @Override
    public List<Supplier> listAll() {
        String sql = "select * from `supplier`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Supplier supplier = null;
        List<Supplier> list = new ArrayList<Supplier>();
        try {
            while (rs.next()) {
                supplier  = new Supplier(
                        rs.getString("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("supplier_address"),
                        rs.getString("supplier_phone")
                );
                list.add(supplier);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Supplier getById(String supplier_id) {
        String sql = "select * from `supplier` where `supplier_id` = ? ";
        Object[] in = new Object[]{supplier_id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Supplier supplier = null;
        try {
            while (rs.next()) {
                supplier  = new Supplier(
                        rs.getString("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("supplier_address"),
                        rs.getString("supplier_phone")
                );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return supplier;
    }

    @Override
    public List<Supplier> getByName(String supplier_name) {
        String sql = "select * from `supplier` where `supplier_name` like '%"+supplier_name+"%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        Supplier supplier = null;
        List<Supplier> list = new ArrayList<Supplier>();
        try {
            while (rs.next()) {
                supplier  = new Supplier(
                        rs.getString("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("supplier_address"),
                        rs.getString("supplier_phone")
                );
                list.add(supplier);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public boolean update(Supplier model) {
        //修改操作
        String sql ="update `supplier` set `supplier_name` = ?,`supplier_address`=?,`supplier_phone`=?  where `supplier_id`= ?";
        Object[] in = new Object[]{model.getSupplier_name(),model.getSupplier_address(),model.getSupplier_phone(),model.getSupplier_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String supplier_id) {
        String sql = "delete from `supplier` where `supplier_id` = ? ";
        Object[] in = new Object[]{supplier_id};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean add(Supplier model) {
        String sql = "insert into `supplier` values(?,?,?,?)";
        Object[] in = new Object[]{model.getSupplier_id(),model.getSupplier_name(),model.getSupplier_address(),model.getSupplier_phone()};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
