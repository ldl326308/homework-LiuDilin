package com.nf147.ldl.phone.entity;

import java.util.Date;

/**
 * 进货类
 * */
public class Purchase {
    int purchase_u_id;  //进行进货的管理员id
    int purchase_id;  //手机id
    int purchase_count;  //数量
    Date purchase_time;  //进货时间
    String purchase_decribe; //描述

    public Purchase(){}

    public Purchase(int purchase_u_id, int purchase_id, int purchase_count, Date purchase_time, String purchase_decribe) {
        this.purchase_u_id = purchase_u_id;
        this.purchase_id = purchase_id;
        this.purchase_count = purchase_count;
        this.purchase_time = purchase_time;
        this.purchase_decribe = purchase_decribe;
    }

    public Purchase(int purchase_u_id, int purchase_id, int purchase_count, String purchase_decribe) {
        this.purchase_u_id = purchase_u_id;
        this.purchase_id = purchase_id;
        this.purchase_count = purchase_count;
        this.purchase_decribe = purchase_decribe;
    }


    public int getPurchase_u_id() {
        return purchase_u_id;
    }

    public void setPurchase_u_id(int purchase_u_id) {
        this.purchase_u_id = purchase_u_id;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public int getPurchase_count() {
        return purchase_count;
    }

    public void setPurchase_count(int purchase_count) {
        this.purchase_count = purchase_count;
    }

    public Date getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(Date purchase_time) {
        this.purchase_time = purchase_time;
    }

    public String getPurchase_decribe() {
        return purchase_decribe;
    }

    public void setPurchase_decribe(String purchase_decribe) {
        this.purchase_decribe = purchase_decribe;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchase_user_id='" + purchase_u_id + '\'' +
                ", purchase_id=" + purchase_id +
                ", purchase_count=" + purchase_count +
                ", purchase_time=" + purchase_time +
                ", purchase_decribe='" + purchase_decribe + '\'' +
                '}';
    }
}
