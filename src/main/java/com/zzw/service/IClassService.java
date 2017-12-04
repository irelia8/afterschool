package com.zzw.service;

import com.zzw.bean.ClassIntro;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface IClassService {
    ArrayList<ClassIntro> GetAllClassIntroByGradeAndSubject(String grade , String subject);
}
