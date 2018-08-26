package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Brand;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements Brand_DAO<Brand> {
    @Override
    public List<Brand> listAll() {
        String sql = "select * from `brand`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Brand brand = null;
        List<Brand> list = new ArrayList<Brand>();
        try {
            while (rs.next()) {
                brand  = new Brand(
                        rs.getInt("b_id"),
                        rs.getString("brand_id"),
                        rs.getString("brand_name")
                );
                list.add(brand);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Brand getById(int brand_id) {
        String sql = "select * from `brand` where `b_id` = ? ";
        Object[] in = new Object[]{brand_id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Brand brand = null;
        try {
            while (rs.next()) {
                brand  = new Brand(
                        rs.getInt("b_id"),
                        rs.getString("brand_id"),
                        rs.getString("brand_name")
                );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return brand;
    }

    @Override
    public List<Brand> getByName(String brand_name) {
        String sql = "select * from `brand` where `brand_name` like '%"+brand_name+"%' or `brand_id` like '%"+brand_name+"%'";
        ResultSet rs = DBUtil.executeQuery(sql);
        Brand brand = null;
        List<Brand> list = new ArrayList<Brand>();
        try {
            while (rs.next()) {
                brand  = new Brand(
                        rs.getInt("b_id"),
                        rs.getString("brand_id"),
                        rs.getString("brand_name")
                );
                list.add(brand);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public boolean update(Brand brand) {
        //修改操作
        String sql ="update `brand` set `brand_name` = ?,`brand_id`=? where `b_id`=?  ";
        Object[] in = new Object[]{brand.getBrand_name(),brand.getBrand_id(),brand.getB_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int brand_id) {
        String sql = "delete from `brand` where `b_id` = ?";
        Object[] in = new Object[]{brand_id};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean add(Brand brand) {
        String sql = "insert into `brand`(brand_id,brand_name) values(?,?)";
        Object[] in = new Object[]{brand.getBrand_id(),brand.getBrand_name()};

        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
