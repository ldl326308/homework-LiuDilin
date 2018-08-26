package com.nf147.ldl.phone.entity;

/**
 * 管理员类
 * */
public class User {
    int u_id;
    String user_id; //管理员登入账号
    String user_name;  //管理员姓名
    String user_pwd;  //登入密码

    public User(){}

    public User(int u_id,String user_id, String user_name, String user_pwd) {
        this.u_id=u_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }


    public User(String user_id, String user_name, String user_pwd) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_pwd = user_pwd;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }


    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }
}
