package com.nf147.ldl.phone.dao;

import java.util.List;

public interface Supplier_DAO<T> {
    List<T> listAll();
    T getById(String supplier_id);
    List<T> getByName(String supplier_name) ;
    boolean update(T model);
    boolean delete(String supplier_id);
    boolean add(T model);
}
