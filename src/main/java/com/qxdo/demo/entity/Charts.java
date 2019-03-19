package com.qxdo.demo.entity;


public class Charts {
    private String title;
    private Integer data;

    @Override
    public String toString() {
        return "Charts{" +
                "title='" + title + '\'' +
                ", data=" + data +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
