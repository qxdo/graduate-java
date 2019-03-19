package com.qxdo.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Message implements Serializable {

    private Integer id;

    private String message;

    private LocalDateTime modifiedtime;

    private User user;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", modifiedtime=" + modifiedtime +
                ", user=" + user +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(LocalDateTime modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
