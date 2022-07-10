package com.example.demo.model;

import java.io.Serializable;

public class RespBean<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    public static RespBean build() {
        return new RespBean();
    }
    public static RespBean success(String msg) {
        return new RespBean(200,msg,null);
    }
    public static <T>RespBean<T> success(String msg, T data) {
        return new RespBean(200,msg,data);
    }
    public static RespBean error(String msg) {
        return new RespBean(500,msg,null);
    }
    public static <T>RespBean<T> error(String msg ,T data) {
        return new RespBean(500,msg,data);
    }

    public RespBean() {
    }

    private RespBean(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public RespBean setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespBean setData(T data) {
        this.data = data;
        return this;
    }

}
