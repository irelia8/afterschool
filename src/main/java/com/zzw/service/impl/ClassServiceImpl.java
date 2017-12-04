package com.zzw.service.impl;

import com.zzw.bean.*;
import com.zzw.dao.IClassDao;
import com.zzw.dao.ITeacherDao;
import org.springframework.stereotype.Service;
import com.zzw.service.IClassService;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/17.
 */

@Service
public class ClassServiceImpl implements IClassService {
    @Resource
    private IClassDao classDao;
    @Resource
    private ITeacherDao teacherDao;


    public ArrayList<ClassIntro> GetAllClassIntroByGradeAndSubject(String grade, String subject) {

        return classDao.GetAllClassIntroByGradeAndSubject(grade, subject);

    }

    public ClassDetailsVo GetClassDetailByCid(int cid) {

        ClassInfo ci = classDao.GetClassInfoByCid(cid);
        ClassDetailsVo cdv = null;
        if (ci != null) {
            int tid = ci.getTeacherid();
            Teacher t = teacherDao.getTeacherByTid(tid);
            cdv = new ClassDetailsVo(t, ci);
        }

        return cdv;

    }


}
