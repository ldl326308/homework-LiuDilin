package com.nf147.ldl.phone.entity;
/**
 * 类型表
 * */
public class Type {
    int t_id;  //手机类型编号
    String type_id;  //手机品牌编号
    String type_name;  //手机名称

    public Type(){}

    public Type(int t_id, String type_id, String type_name) {
        this.t_id = t_id;
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public Type(String type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "t_id=" + t_id +
                ", type_id='" + type_id + '\'' +
                ", type_name='" + type_name + '\'' +
                '}';
    }
}
