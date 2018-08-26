package com.nf147.ldl.phone.dao;

import com.nf147.ldl.phone.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface User_DAO<T> {
    List<T> listAll();
    T getById(int id);
    List<T> getByName(String name) ;
    boolean update(T model);
    boolean delete(int id);
    boolean add(T model);
}
