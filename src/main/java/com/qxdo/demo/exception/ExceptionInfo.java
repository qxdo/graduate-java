package com.qxdo.demo.exception;

public class ExceptionInfo extends CommonException {
    private Integer status;
    private String message;

    public ExceptionInfo(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionInfo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
