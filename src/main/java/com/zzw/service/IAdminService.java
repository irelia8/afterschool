package com.zzw.service;

import com.zzw.bean.Amount;
import com.zzw.bean.ClassInfo;
import com.zzw.bean.Teacher;
import com.zzw.bean.User;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/23.
 */
public interface IAdminService {


    Amount getAmount();

    ArrayList<User> getUserByPage(int page, int pagesize);

    ArrayList<Teacher> getTeacherByPage(int page, int pagesize);

    ArrayList<User> getAdminByPage(int page, int pagesize);

    int addTeacher(Teacher teacher);

    int addClassInfo(ClassInfo classinfo);

    int addAdmin(User user);

    Teacher getTeacherByTid(int tid);

    int modifyTeacherByTeacher(Teacher teacher);


    int modifyClassInfoByClassInfo(ClassInfo classInfo);

    int deleteClassInfoByCid(int cid);

    int deleteTeacherByTid(int tid);

    int usernameIsExist(String username);

    int adminLogin(String username, String password);
}
