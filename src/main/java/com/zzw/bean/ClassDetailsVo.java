package com.zzw.bean;

/**
 * Created by 张志伟 on 2017/11/21.
 */
public class ClassDetailsVo {

    private Teacher teacher;

    private  ClassInfo classinfo;


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ClassInfo getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(ClassInfo classinfo) {
        this.classinfo = classinfo;
    }

    public ClassDetailsVo(Teacher teacher, ClassInfo classinfo) {
        this.teacher = teacher;
        this.classinfo = classinfo;
    }
}

