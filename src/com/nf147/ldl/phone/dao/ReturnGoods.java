package com.nf147.ldl.phone.dao;

import utils.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnGoods implements Purchase_DAO<ReturnGoods> {

    @Override
    public List<ReturnGoods> listAll() {
        return null;
    }

    @Override
    public List<ReturnGoods> getByUserId(int purchase_u_id) {
        return null;
    }

    @Override
    public List<ReturnGoods> getByPhoneId(int purchase_id) {
        return null;
    }

    @Override
    public boolean update(ReturnGoods model) {
        return false;
    }

    @Override
    public boolean delete(ReturnGoods model) {
        return false;
    }

    @Override
    public boolean add(ReturnGoods model) {
        return false;
    }
}
