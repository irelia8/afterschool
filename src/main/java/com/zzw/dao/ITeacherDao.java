package com.zzw.dao;


import com.zzw.bean.Teacher;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface ITeacherDao {

    Teacher getTeacherByTid (int tid);



    String teacherIdIsExist(Integer tid);
}
