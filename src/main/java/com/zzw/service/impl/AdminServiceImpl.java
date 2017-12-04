package com.zzw.service.impl;

import com.zzw.bean.Amount;
import com.zzw.bean.ClassInfo;
import com.zzw.bean.Teacher;
import com.zzw.bean.User;
import com.zzw.dao.IAdminDao;
import com.zzw.dao.ITeacherDao;
import com.zzw.dao.IUserDao;
import org.springframework.stereotype.Service;
import com.zzw.service.IAdminService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/23.
 */
@Service
public class AdminServiceImpl implements IAdminService{

    @Resource
    private IAdminDao adminDao;
    @Resource
    private IUserDao userDao;
    @Resource
    private ITeacherDao teacherDao;

    public ArrayList<User> getUserByPage(int page, int pagesize) {

        int pagestart = 0;
        if (page != 0){
            pagestart = page*pagesize-1;
        }
        return adminDao.getUserByPage(pagestart,pagesize);
    }

    public ArrayList<Teacher> getTeacherByPage(int page, int pagesize) {
        int pagestart = 0;
        if (page != 0){
            pagestart = page*pagesize-1;
        }
        return adminDao.getTeacherByPage(pagestart,pagesize);
    }

    public ArrayList<User> getAdminByPage(int page, int pagesize) {

        int pagestart = 0;
        if (page != 0){
            pagestart = page*pagesize-1;
        }
        return adminDao.getAdminByPage(pagestart,pagesize);
    }

    public Amount getAmount() {
        Amount amount = new Amount(
                adminDao. getUserAmount(),
                adminDao. getTeacherAmount(),
                adminDao. getAdminAmount(),
                adminDao. getChineseAmount(),
                adminDao. getMathAmount(),
                adminDao. getEnglishAmount(),
                adminDao. getPhysicsAmount(),
                adminDao. getChemistryAmount(),
                adminDao. getBiologyAmount());

        return amount;
    }

    public int addTeacher(Teacher teacher) {
        int result = adminDao.addTeacher(teacher);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int addClassInfo(ClassInfo classinfo) {
        int result = adminDao.addClassInfo(classinfo);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int addAdmin(User user) {
        int result = adminDao.addAdmin(user);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public Teacher getTeacherByTid(int tid) {
        return teacherDao.getTeacherByTid(tid);
    }

    public int modifyTeacherByTeacher(Teacher teacher) {
        int result = adminDao.modifyTeacherByTeacher(teacher);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int modifyClassInfoByClassInfo(ClassInfo classInfo) {
        int result = adminDao.modifyClassInfoByClassInfo(classInfo);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int deleteClassInfoByCid(int cid) {
        int result = adminDao.deleteClassInfoByCid(cid);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int deleteTeacherByTid(int tid) {
        int result = adminDao.deleteTeacherByTid(tid);
        if (result == 0) {
            return 1;
        }
        return 0;
    }

    public int usernameIsExist(String username) {
        String result = adminDao.usernameIsExist(username);
        if (result == null) {
            return 0;
        }
        return 1;
    }

    public int adminLogin(String username, String password) {

        String gettedPwd = userDao.adminLogin(username);
        if (gettedPwd != null) {
            //密码错误返回2
            if ((gettedPwd.equals(password))) {
                return 0;
            } else {
                return 2;
            }
        }
        //没有该用户返回1
        return 1;
    }


}
