package com.nf147.ldl.phone.entity;

import java.math.BigDecimal;

/**
 * 手机信息
 * */
public class Phone {
    int phone_id;  //类型编号
    BigDecimal phone_price;  //价格
    int phone_state;  //状态
    String phone_supplier;  //供应商编号
    String phone_describe;  //描述

    public Phone(){}

    public Phone(int phone_id, BigDecimal phone_price, int phone_state, String phone_supplier, String phone_describe) {
        this.phone_id = phone_id;
        this.phone_price = phone_price;
        this.phone_state = phone_state;
        this.phone_supplier = phone_supplier;
        this.phone_describe = phone_describe;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public BigDecimal getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(BigDecimal phone_price) {
        this.phone_price = phone_price;
    }

    public int getPhone_state() {
        return phone_state;
    }

    public void setPhone_state(int phone_state) {
        this.phone_state = phone_state;
    }

    public String getPhone_supplier() {
        return phone_supplier;
    }

    public void setPhone_supplier(String phone_supplier) {
        this.phone_supplier = phone_supplier;
    }

    public String getPhone_describe() {
        return phone_describe;
    }

    public void setPhone_describe(String phone_describe) {
        this.phone_describe = phone_describe;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone_id=" + phone_id +
                ", phone_price=" + phone_price +
                ", phone_state=" + phone_state +
                ", phone_supplier='" + phone_supplier + '\'' +
                ", phone_describe='" + phone_describe + '\'' +
                '}';
    }
}
