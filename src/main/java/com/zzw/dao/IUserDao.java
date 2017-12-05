package com.zzw.dao;

import com.zzw.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface IUserDao {
    int addUser(User user);
    User getUserByUid(int uid);
    User studentLogin(@Param("username")String name);
    User teacherLogin(@Param("username")String name);
    String adminLogin(@Param("username")String name);
    int modifyUserByUser(User u);
}
