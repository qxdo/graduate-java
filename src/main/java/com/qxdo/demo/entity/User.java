package com.qxdo.demo.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User implements Serializable {

    private Integer id;
    /*@NotBlank*/
    private String username;


    private LocalDate birthday;

    private String address;

    private String contact;

    private Integer sex;

    private Integer levele;

    private LocalDateTime modifiedtime;

    //备注
    private String backup;



    //是否删除，删除了设置1，正常设置0
    private Integer deleted;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", sex=" + sex +
                ", levele=" + levele +
                ", modifiedtime=" + modifiedtime +
                ", backup='" + backup + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Integer getLevele() {
        return levele;
    }

    public void setLevele(Integer level) {
        this.levele = level;
    }

    public LocalDateTime getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(LocalDateTime modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

}
