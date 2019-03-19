package com.qxdo.demo.entity;

import java.io.Serializable;

public class Node implements Serializable {

    private Integer id;

    private Integer pid;

    private String label;

    private Integer leaf;

    private String url;

    private Integer rank;//排层

    public Node(){}




    public Node(Integer id, Integer pid, String label, Integer leaf, String url, Integer rank) {
        this.id = id;
        this.pid = pid;
        this.label = label;
        this.leaf = leaf;
        this.url = url;
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", pid=" + pid +
                ", label='" + label + '\'' +
                ", leaf=" + leaf +
                ", url='" + url + '\'' +
                ", rank=" + rank +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
