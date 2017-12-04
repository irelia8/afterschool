package com.zzw.utils;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public class Result<D> {
    private int code;
    private String msg;
    private D data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
