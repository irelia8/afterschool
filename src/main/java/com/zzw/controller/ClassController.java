package com.zzw.controller;

import com.zzw.bean.ClassDetailsVo;
import com.zzw.bean.ClassIntro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zzw.service.impl.ClassServiceImpl;

import com.zzw.utils.Result;

import javax.annotation.Resource;
import java.util.ArrayList;


/**
 * Created by 张志伟 on 2017/11/20.
 */

@Controller
@RequestMapping("/class")
public class ClassController {

    @Resource
    private ClassServiceImpl classService;


    @ResponseBody
    @RequestMapping("GetAllClassIntro")
    Result GetAllClassIntroByGradeAndSubject(String grade, String subject) {
        ArrayList<ClassIntro> ciList = classService.GetAllClassIntroByGradeAndSubject(grade, subject);
        Result<ArrayList<ClassIntro>> stringResult = new Result<ArrayList<ClassIntro>>();
        if (ciList.isEmpty()) {
            stringResult.setCode(1);
            stringResult.setMsg("查询不到课程记录");
        } else {
            stringResult.setCode(0);
            stringResult.setMsg("查询成功");
        }
        stringResult.setData(ciList);
        return stringResult;

    }



    @ResponseBody
    @RequestMapping("GetClassDetailByCid")
    Result GetClassDetailByCid(Integer cid) {
        ClassDetailsVo cdv = classService.GetClassDetailByCid(cid);
        Result<ClassDetailsVo> stringResult = new Result<ClassDetailsVo>();
        if (cdv == null) {
            stringResult.setCode(1);
            stringResult.setMsg("查询不到课程记录");
        } else {
            stringResult.setCode(0);
            stringResult.setMsg("查询成功");
        }
        stringResult.setData(cdv);
        return stringResult;
    }


}
