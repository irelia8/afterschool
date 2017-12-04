package com.zzw.bean;

import java.util.Date;

public class OrderForm {
    private Integer id;//订单id

    private Date ordertime;//订单生成时间

    private Integer userid;//用户id

    private Integer classid;//课程id

    private Integer ispay;//是否支付

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }


    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }
}