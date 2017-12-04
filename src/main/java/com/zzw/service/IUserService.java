package com.zzw.service;

import com.zzw.bean.User;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface IUserService {
    int addUser(User user);
    User getUserByUid(int uid);
    User studentLogin(String username , String password);
    int teacherLogin(String username , String password);
    int modifyUserByUser(User u);

    int teacherIdIsExist(Integer tid);
}
