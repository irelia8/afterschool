package com.zzw.service.impl;

import com.zzw.bean.User;
import com.zzw.dao.ITeacherDao;
import com.zzw.dao.IUserDao;
import org.springframework.stereotype.Service;
import com.zzw.service.IUserService;

import javax.annotation.Resource;

/**
 * Created by 张志伟 on 2017/11/17.
 */

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;
    @Resource
    private ITeacherDao teacherDao;



    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUserByUid(int uid) {
        return userDao.getUserByUid(uid);
    }

    public User studentLogin(String username, String password) {

        User gettedUser = userDao.studentLogin(username);
        return gettedUser;

    }

    public User teacherLogin(String username, String password) {

        User gettedUser = userDao.teacherLogin(username);
        return gettedUser;

    }

    public int modifyUserByUser(User u) {
        int result = userDao.modifyUserByUser(u);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int teacherIdIsExist(Integer tid) {
        String result = teacherDao.teacherIdIsExist(tid);
        if (result != null) {
            return 0;
        }
        return 1;
    }


}
