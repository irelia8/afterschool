package com.zzw.service.impl;

import com.zzw.bean.ClassDetailsVo;
import com.zzw.bean.ClassInfo;
import com.zzw.bean.OrderForm;
import com.zzw.bean.Teacher;
import com.zzw.dao.IClassDao;
import com.zzw.dao.IOrderFormDao;
import com.zzw.dao.ITeacherDao;
import org.springframework.stereotype.Service;
import com.zzw.service.IOrderFormService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 张志伟 on 2017/11/22.
 */
@Service
public class OrderFormServiceImpl implements IOrderFormService {
    @Resource
    private IOrderFormDao orderformDao;
    @Resource
    private IClassDao classDao;
    @Resource
    private ITeacherDao teacherDao;

    /**
     * desc：通过用户ID获取订单实体
     *
     */
    public ArrayList<ClassDetailsVo> getOrderFormByUid(Integer uid) {
        ArrayList<Integer> cidList = orderformDao.getOrderFormCidByUid(uid);
        ArrayList<ClassDetailsVo> classInfoList = new ArrayList<ClassDetailsVo>();

        if (!cidList.isEmpty()) {
            for (Integer cid : cidList) {
                ClassInfo ci = classDao.GetClassInfoByCid(cid);
                int tid = ci.getTeacherid();
                Teacher t = teacherDao.getTeacherByTid(tid);
                ClassDetailsVo cdv = new ClassDetailsVo(t, ci);
                classInfoList.add(cdv);
            }
        }

        return classInfoList;
    }


    /**
     * desc：通过订单ID支付订单
     *
     */
    public int payOrderFormByOid(Integer oid) {
        int result = orderformDao.payOrderFormByOid(oid);
        if (result == 0) {
            return 1;
        }
        return 0;
    }


    /**
     * desc：通过用户ID支付购物车内所有订单
     *
     */
    public int payShoppingCartByUid(Integer uid) {
        int result = orderformDao.payShoppingCartByUid(uid);
        if (result == 0) {
            return 1;
        }
        return 0;
    }


    /**
     * desc：通过用户ID和课程ID新增一个订单（未支付）
     *
     */
    public int addOrderFormByOrderForm(Integer cid, Integer uid) {
        OrderForm of = new OrderForm();
        of.setOrdertime(new Date());
        of.setClassid(cid);
        of.setUserid(uid);
        of.setIspay(0);

        int result = orderformDao.addOrderFormByOrderForm(of);
        if (result == 0) {
            return 1;
        }
        return 0;

    }


    /**
     * desc：通过用户ID获取该用户购物车内的订单（所有未支付订单）
     *
     */
    public ArrayList<ClassDetailsVo> getShoppingCartByUid(Integer uid) {
        ArrayList<Integer> cidList = orderformDao.getShoppingCartCidByUid(uid);
        ArrayList<ClassDetailsVo> classInfoList = new ArrayList<ClassDetailsVo>();

        if (!cidList.isEmpty()) {
            for (Integer cid : cidList) {
                ClassInfo ci = classDao.GetClassInfoByCid(cid);
                int tid = ci.getTeacherid();
                Teacher t = teacherDao.getTeacherByTid(tid);
                ClassDetailsVo cdv = new ClassDetailsVo(t, ci);
                classInfoList.add(cdv);
            }
        }

        return classInfoList;
    }



}
