package com.qxdo.demo.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 客户
 */
public class Customer implements Serializable {

    private Integer id;

    private String name; //客户名

    private Integer typeid;//客户的类型ID

    private String companyname;//客户公司名称

    private String phone;

    private String email;


    private String url;//公司的URL

    private String desc;//描述

    private Integer imcount;//员工数量

    private Integer deleted;//是否删除，删除1,正常0

    private LocalDateTime modifiedtime;

    private CType type;



    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeid=" + typeid +
                ", companyname='" + companyname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                ", imcount=" + imcount +
                ", deleted=" + deleted +
                ", modifiedtime=" + modifiedtime +
                '}';
    }

    public CType getType() {
        return type;
    }

    public void setType(CType type) {
        this.type = type;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public LocalDateTime getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(LocalDateTime modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getImcount() {
        return imcount;
    }

    public void setImcount(Integer imcount) {
        this.imcount = imcount;
    }
}
