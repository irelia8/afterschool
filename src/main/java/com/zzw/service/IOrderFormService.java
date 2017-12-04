package com.zzw.service;

import com.zzw.bean.ClassDetailsVo;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/22.
 */
public interface IOrderFormService {
    ArrayList<ClassDetailsVo> getOrderFormByUid(Integer uid);

    int payOrderFormByOid(Integer oid);

    int payShoppingCartByUid(Integer uid);

    int addOrderFormByOrderForm(Integer cid, Integer uid);
}
