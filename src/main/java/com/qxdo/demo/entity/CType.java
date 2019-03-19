package com.qxdo.demo.entity;

/**
 * 客户的类型
 *
 */
public class CType {

    private Integer id;

    private String name;//类型

    private String desc;//描述

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
