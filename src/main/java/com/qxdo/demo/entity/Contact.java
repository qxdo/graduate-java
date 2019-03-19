package com.qxdo.demo.entity;

import java.io.Serializable;

/**
 * 联系人,联系人是一个统一的集合，包括客户和潜在客户
 *
 */
public class Contact implements Serializable {

    private Integer id;
    private String name;//姓名
    private String customername;//客户姓名
    private String phone;//客户电话
    private String email;//邮件
    private String nickname;//别名


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customername='" + customername + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
