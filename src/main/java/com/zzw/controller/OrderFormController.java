package com.zzw.controller;


import com.zzw.bean.ClassDetailsVo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.zzw.service.impl.OrderFormServiceImpl;
import com.zzw.utils.Result;


import javax.annotation.Resource;
import java.util.ArrayList;


/**
 * Created by 张志伟 on 2017/11/20.
 */

@Controller
@RequestMapping("/orderform")
public class OrderFormController {

    @Resource
    private OrderFormServiceImpl orderformService;

    /**
     * desc：通过用户ID获取所有订单（已支付 - 我的订单）
     *
     */
    @ResponseBody
    @RequestMapping("getOrderFormByUid")
    Result<ArrayList<ClassDetailsVo>> getOrderFormByUid(Integer uid) {
        ArrayList<ClassDetailsVo> ofList = orderformService.getOrderFormByUid(uid);
        Result<ArrayList<ClassDetailsVo>> stringResult = new Result<ArrayList<ClassDetailsVo>>();
        if (ofList.isEmpty()) {
            stringResult.setCode(1);
            stringResult.setMsg("查询不到订单记录");
        } else {
            stringResult.setCode(0);
            stringResult.setMsg("查询成功");
        }
        stringResult.setData(ofList);
        return stringResult;
    }

    /**
     * desc：通过用户ID获取课程表（已支付 - 我的订单）
     *
     */
    @ResponseBody
    @RequestMapping("getClassTableByUid")
    Result<ArrayList<ClassDetailsVo>> getClassTableByUid(Integer uid) {
        ArrayList<ClassDetailsVo> ofList = orderformService.getOrderFormByUid(uid);
        Result<ArrayList<ClassDetailsVo>> stringResult = new Result<ArrayList<ClassDetailsVo>>();
        if (ofList.isEmpty()) {
            stringResult.setCode(1);
            stringResult.setMsg("查询不到订单记录");
        } else {
            stringResult.setCode(0);
            stringResult.setMsg("查询成功");
        }
        stringResult.setData(ofList);
        return stringResult;
    }

    /**
     *
     *  desc：通过用户ID获取该用户购物车内的订单（未支付 - 购物车车）
     */
    @ResponseBody
    @RequestMapping("getShoppingCartByUid")
    Result<ArrayList<ClassDetailsVo>> getShoppingCartByUid(Integer uid) {
        ArrayList<ClassDetailsVo> ofList = orderformService.getShoppingCartByUid(uid);
        Result<ArrayList<ClassDetailsVo>> stringResult = new Result<ArrayList<ClassDetailsVo>>();
        if (ofList.isEmpty()) {
            stringResult.setCode(1);
            stringResult.setMsg("查询不到购物车记录");
        } else {
            stringResult.setCode(0);
            stringResult.setMsg("查询成功");
        }
        stringResult.setData(ofList);
        return stringResult;
    }

    /**
     *
     * desc：通过订单ID支付订单
     */
    @ResponseBody
    @RequestMapping("payOrderFormByOid")
    Result<String> payOrderFormByOid(Integer oid) {

        int modifyResult = orderformService.payOrderFormByOid(oid);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setMsg("支付失败");
        } else if (modifyResult == 0) {
            stringResult.setMsg("支付成功");
        }
        return stringResult;
    }

    /**
     *
     * desc：通过用户ID支付购物车内所有订单
     */
    @ResponseBody
    @RequestMapping("payShoppingCartByUid")
    Result<String> payShoppingCartByUid(Integer uid) {

        int modifyResult = orderformService.payShoppingCartByUid(uid);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setMsg("支付失败");
        } else if (modifyResult == 0) {
            stringResult.setMsg("支付成功");
        }
        return stringResult;
    }

    /**
     *
     *  desc：通过用户ID和课程ID新增一个订单（未支付 - 购物车车）
     */
    @ResponseBody
    @RequestMapping("addOrderFormByCidAndUid")
    Result<String> addOrderFormByCidAndUid(Integer cid,Integer uid) {

        int modifyResult = orderformService.addOrderFormByOrderForm(cid,uid);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setMsg("添加失败");
        } else if (modifyResult == 0) {
            stringResult.setMsg("添加成功");
        }
        return stringResult;
    }

}
