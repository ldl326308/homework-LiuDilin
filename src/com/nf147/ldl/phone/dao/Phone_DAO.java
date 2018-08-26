package com.nf147.ldl.phone.dao;

import java.util.List;

public interface Phone_DAO<T> {
    List<T> listAll();
    T getById(int phone_id);
    List<T> getByName(String type_name) ;
    boolean update(T model);
    boolean delete(int phone_id);
    boolean add(T model);
}
