package com.nf147.ldl.phone.dao;

import java.util.List;

public interface Purchase_DAO<T> {
    List<T> listAll();
    List<T> getByUserId(int purchase_u_id);
    List<T> getByPhoneId(int purchase_id);
    boolean update(T model);
    boolean delete(T model);
    boolean add(T model);
}
