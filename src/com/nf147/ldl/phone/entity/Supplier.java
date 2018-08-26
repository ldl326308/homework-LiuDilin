package com.nf147.ldl.phone.entity;

/**
 * 供应商类
 * */
public class Supplier {
    String supplier_id;  //供应商的编号
    String supplier_name;  //供应商名称
    String supplier_address;   //供应商地址
    String supplier_phone;  //供应商的联系方式

    public Supplier(){}

    public Supplier(String supplier_id, String supplier_name, String supplier_address, String supplier_phone) {
        this.supplier_id = supplier_id;
        this.supplier_name = supplier_name;
        this.supplier_address = supplier_address;
        this.supplier_phone = supplier_phone;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getSupplier_address() {
        return supplier_address;
    }

    public void setSupplier_address(String supplier_address) {
        this.supplier_address = supplier_address;
    }

    public String getSupplier_phone() {
        return supplier_phone;
    }

    public void setSupplier_phone(String supplier_phone) {
        this.supplier_phone = supplier_phone;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id='" + supplier_id + '\'' +
                ", supplier_name='" + supplier_name + '\'' +
                ", supplier_address='" + supplier_address + '\'' +
                ", supplier_phone='" + supplier_phone + '\'' +
                '}';
    }
}
