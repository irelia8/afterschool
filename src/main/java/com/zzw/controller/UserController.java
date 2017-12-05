package com.zzw.controller;

import com.zzw.bean.User;
import org.apache.log4j.LogManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zzw.service.impl.UserServiceImpl;
import com.zzw.utils.Result;

import javax.annotation.Resource;

/**
 * Created by 张志伟 on 2017/11/17.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserServiceImpl userService;
    private static org.apache.log4j.Logger logger = LogManager.getLogger(UserController.class);


    @ResponseBody
    @RequestMapping("addUser")
    public Result<String> addUser(@RequestBody User user) {

        int add = userService.addUser(user);
        Result<String> stringResult = new Result<String>();

        if (add > 0) {
            stringResult.setCode(0);
            stringResult.setData("成功");
            stringResult.setMsg("注册成功");
        } else {
            stringResult.setCode(101);
            stringResult.setData("失败");
            stringResult.setMsg("用户名重复,注册失败");
        }
        return stringResult;
    }

    @ResponseBody
    @RequestMapping("teacherIdIsExist")
    public Result<String> teacherIdIsExist(Integer tid) {
        logger.debug(String.valueOf(tid));
        logger.info(String.valueOf(tid));
        int modifyResult = userService.teacherIdIsExist(tid);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setCode(102);
            stringResult.setData("失败");
            stringResult.setMsg("教师不存在，不可插入");
        } else if (modifyResult == 0) {
            stringResult.setCode(0);
            stringResult.setData("成功");
            stringResult.setMsg("教师存在，可以插入");
        }
        return stringResult;
    }


    @ResponseBody
    @RequestMapping("studentLogin")
    public Result<User> studentLogin(String username, String password) {

        User u = userService.studentLogin(username, password);
        Result<User> stringResult = new Result<User>();

        if (u != null) {

            if ((u.getPassword().equals(password))) {
                //成功返回0
                stringResult.setCode(0);
                stringResult.setData(u);
                stringResult.setMsg("登录成功");
            } else {
                //密码错误返回2
                stringResult.setCode(104);
                stringResult.setMsg("密码错误");
            }
        }
        //没有该用户返回1
        stringResult.setCode(103);
        stringResult.setMsg("没有此用户");


        return stringResult;
    }


    @ResponseBody
    @RequestMapping("teacherLogin")
    public Result<User> teacherLogin(String username, String password) {

        User u = userService.teacherLogin(username, password);
        Result<User> stringResult = new Result<User>();

        if (u != null) {

            if ((u.getPassword().equals(password))) {
                //成功返回0
                stringResult.setCode(0);
                stringResult.setData(u);
                stringResult.setMsg("登录成功");
            } else {
                //密码错误返回2
                stringResult.setCode(104);
                stringResult.setMsg("密码错误");
            }
        }
        //没有该用户返回1
        stringResult.setCode(103);
        stringResult.setMsg("没有此用户");


        return stringResult;
    }

    @ResponseBody
    @RequestMapping("modifyUserByUser")
    public Result<String> modifyUserByUser(User user) {

        int modifyResult = userService.modifyUserByUser(user);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setMsg("修改失败");
        } else if (modifyResult == 0) {
            stringResult.setMsg("修改成功");
        }
        return stringResult;
    }

    @ResponseBody
    @RequestMapping("getUserByUid")
    public Result<User> getUserByUid(int uid) {
        User user = userService.getUserByUid(uid);
        Result<User> result = new Result<User>();
        result.setData(user);
        result.setMsg("成功");
        result.setCode(0);

        return result;
    }

}
