package com.nf147.ldl.phone.dao;

import java.util.List;

public interface Type_DAO<T> {
    List<T> listAll();
    T getById(int id);
    List<T> getByName(String name) ;
    boolean update(T model);
    boolean delete(int id);
    boolean add(T model);
}
