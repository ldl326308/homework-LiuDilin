package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.Stock;
import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDAO implements Stock_DAO<Stock> {
    @Override
    public List<Stock> listAll() {
        String sql = "select * from `Stock`";
        ResultSet rs = DBUtil.executeQuery(sql);
        Stock stock = null;
        List<Stock> list = new ArrayList<Stock>();
        try {
            while (rs.next()) {
                stock  = new Stock(
                       rs.getInt("stock_id"),
                       rs.getInt("stock_count")
                );
                list.add(stock);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Stock getById(int stock_id) {
        String sql = "select * from `stock` where `stock_id` = ? ";
        Object[] in = new Object[]{stock_id};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Stock stock = null;
        try {
            while (rs.next()) {
                stock  = new Stock(
                        rs.getInt("stock_id"),
                        rs.getInt("stock_count")
                );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return stock;
    }

    @Override
    public boolean update(Stock model) {
        String sql ="update `stock` set `stock_count` = ? where `stock_id`= ?";
        Object[] in = new Object[]{model.getStock_count(),model.getStock_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int stock_id) {
        String sql = "delete from `stock` where `stock_id` = ?";
        Object[] in = new Object[]{stock_id};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Stock model) {
        String sql = "insert into `stock` values(?,?)";
        Object[] in = new Object[]{model.getStock_id(),model.getStock_count()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
