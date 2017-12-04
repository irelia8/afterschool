package com.zzw.dao;

import com.zzw.bean.ClassInfo;
import com.zzw.bean.ClassIntro;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/17.
 */
public interface IClassDao {


   ArrayList<ClassIntro> GetAllClassIntroByGradeAndSubject(@Param("grade")String grade, @Param("subject")String subject);


   ClassInfo  GetClassInfoByCid (int cid);


}
