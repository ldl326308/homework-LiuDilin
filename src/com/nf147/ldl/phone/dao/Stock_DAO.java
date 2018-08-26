package com.nf147.ldl.phone.dao;

import java.util.List;

public interface Stock_DAO<T> {
    List<T> listAll();
    T getById(int stock_id);
    boolean update(T model);
    boolean delete(int stock_id);
    boolean add(T model);
}
