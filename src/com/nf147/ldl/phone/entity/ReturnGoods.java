package com.nf147.ldl.phone.entity;

import java.util.Date;

/**
 * 退货类
 * */
public class ReturnGoods {
		int returnGoods_user_id;  //进行退货的管理员id
		int returnGoods_id;  //退货的手机id
        int returnGoods_count;  //退货的数量
        Date returnGoods_time;  //退货的时间
        String returnGoods_decribe;  //描述


    public ReturnGoods() {
    }

    public ReturnGoods(int returnGoods_user_id, int returnGoods_id, int returnGoods_count, Date returnGoods_time, String returnGoods_decribe) {

        this.returnGoods_user_id = returnGoods_user_id;
        this.returnGoods_id = returnGoods_id;
        this.returnGoods_count = returnGoods_count;
        this.returnGoods_time = returnGoods_time;
        this.returnGoods_decribe = returnGoods_decribe;
    }

    public int getReturnGoods_user_id() {
        return returnGoods_user_id;
    }

    public void setReturnGoods_user_id(int returnGoods_user_id) {
        this.returnGoods_user_id = returnGoods_user_id;
    }

    public int getReturnGoods_id() {
        return returnGoods_id;
    }

    public void setReturnGoods_id(int returnGoods_id) {
        this.returnGoods_id = returnGoods_id;
    }

    public int getReturnGoods_count() {
        return returnGoods_count;
    }

    public void setReturnGoods_count(int returnGoods_count) {
        this.returnGoods_count = returnGoods_count;
    }

    public Date getReturnGoods_time() {
        return returnGoods_time;
    }

    public void setReturnGoods_time(Date returnGoods_time) {
        this.returnGoods_time = returnGoods_time;
    }

    public String getReturnGoods_decribe() {
        return returnGoods_decribe;
    }

    public void setReturnGoods_decribe(String returnGoods_decribe) {
        this.returnGoods_decribe = returnGoods_decribe;
    }
}
