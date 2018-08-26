package com.nf147.ldl.phone.entity;

/**
 * 库存类
 * */
public class Stock {
    int stock_id;  //手机类型
    int stock_count; //数量

    public Stock(){

    }

    public Stock(int stock_id, int stock_count) {
        this.stock_id = stock_id;
        this.stock_count = stock_count;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getStock_count() {
        return stock_count;
    }

    public void setStock_count(int stock_count) {
        this.stock_count = stock_count;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock_id=" + stock_id +
                ", stock_count=" + stock_count +
                '}';
    }
}
