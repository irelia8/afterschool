package com.zzw.dao;

import com.zzw.bean.OrderForm;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/22.
 */
public interface IOrderFormDao {

    ArrayList<Integer> getOrderFormCidByUid(Integer uid);

    ArrayList<Integer> getShoppingCartCidByUid(Integer uid);

    int payOrderFormByOid(Integer oid);

    int payShoppingCartByUid(Integer uid);

    int addOrderFormByOrderForm(OrderForm orderform);

}
