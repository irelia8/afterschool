package com.zzw.dao;

import com.zzw.bean.ClassInfo;
import com.zzw.bean.Teacher;
import com.zzw.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface IAdminDao {


   int getUserAmount();
   int getTeacherAmount();
   int getAdminAmount();
   int getChineseAmount();
   int getMathAmount();
   int getEnglishAmount();
   int getPhysicsAmount();
   int getChemistryAmount();
   int getBiologyAmount();

   ArrayList<User> getUserByPage(@Param("pagestart")int pagestart, @Param("pagesize")int pagesize);
   ArrayList<Teacher> getTeacherByPage(@Param("pagestart")int pagestart, @Param("pagesize")int pagesize);
   ArrayList<User> getAdminByPage(@Param("pagestart")int pagestart, @Param("pagesize")int pagesize);


   ArrayList<User> getAllAdmin();


   int addTeacher(Teacher teacher);

   int addClassInfo(ClassInfo classinfo);

   int addAdmin(User user);

   Teacher getTeacherByTid();

   int modifyTeacherByTeacher(Teacher teacher);

   int modifyClassInfoByClassInfo(ClassInfo classInfo);

   int deleteClassInfoByCid(int cid);

   int deleteTeacherByTid(int tid);

   String usernameIsExist(@Param("isexistname")String username);
}
