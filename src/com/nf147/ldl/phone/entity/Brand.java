package com.nf147.ldl.phone.entity;

/**
 * 品牌类
 * */
public class Brand {
    int b_id;  //id
    String  brand_id;  //手机品牌编号
    String brand_name;  //手机品牌名称

    public Brand(){}

    public Brand(int b_id,String brand_id, String brand_name) {
        this.b_id = b_id;
        this.brand_id = brand_id;
        this.brand_name = brand_name;
    }

    public Brand(String brand_id, String brand_name) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id='" + brand_id + '\'' +
                ", brand_name='" + brand_name + '\'' +
                '}';
    }
}
