package com.zzw.controller;

import com.zzw.bean.Amount;
import com.zzw.bean.ClassInfo;
import com.zzw.bean.Teacher;
import com.zzw.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zzw.service.impl.AdminServiceImpl;
import com.zzw.utils.Result;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by 张志伟 on 2017/11/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminServiceImpl adminService;
    

    @ResponseBody
    @RequestMapping("getUserByPage")
    public Result<ArrayList<User>> getUserByPage(int page ,int pagesize) {
        ArrayList<User> userList = adminService.getUserByPage(page,pagesize);
        Result< ArrayList<User>> result = new Result< ArrayList<User>>();

        if (userList.isEmpty()) {
            result.setCode(1);
            result.setMsg("查询失败");
        } else {
            result.setCode(0);
            result.setMsg("查询成功");
        }
        result.setData(userList);
        return result;
    }


    @ResponseBody
    @RequestMapping("getAdminByPage")
    public Result<ArrayList<User>> getAdminByPage(int page ,int pagesize) {
        ArrayList<User> userList = adminService.getAdminByPage(page , pagesize);
        Result< ArrayList<User>> result = new Result< ArrayList<User>>();

        if (userList.isEmpty()) {
            result.setCode(1);
            result.setMsg("查询失败");
        } else {
            result.setCode(0);
            result.setMsg("查询成功");
        }
        result.setData(userList);
        return result;
    }


    @ResponseBody
    @RequestMapping("getTeacherByPage")
    public Result<ArrayList<Teacher>> getTeacherByPage(int page ,int pagesize) {
        ArrayList<Teacher> teacherList = adminService.getTeacherByPage(page,pagesize);
        Result< ArrayList<Teacher>> result = new Result< ArrayList<Teacher>>();

        if (teacherList.isEmpty()) {
            result.setCode(1);
            result.setMsg("查询失败");
        } else {
            result.setCode(0);
            result.setMsg("查询成功");
        }
        result.setData(teacherList);
        return result;
    }


    @ResponseBody
    @RequestMapping("getAmount")
    public Result<Amount> getAmount() {
        Amount amount = adminService.getAmount();
        Result<Amount> result = new Result<Amount>();

        if (amount == null) {
            result.setCode(1);
            result.setMsg("查询失败");
        } else {
            result.setCode(0);
            result.setMsg("查询成功");
        }
        result.setData(amount);
        return result;

    }



    @ResponseBody
    @RequestMapping("addTeacher")
    public Result<String> addTeacher(Teacher teacher) {

        int addResult = adminService.addTeacher(teacher);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(addResult);
        if (addResult == 1) {
            stringResult.setMsg("添加失败");
        } else if (addResult == 0) {
            stringResult.setMsg("添加成功");
        }
        return stringResult;

    }


    @ResponseBody
    @RequestMapping("addClassInfo")
    public Result<String> addClassInfo(ClassInfo classinfo) {

        int addResult = adminService.addClassInfo(classinfo);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(addResult);
        if (addResult == 1) {
            stringResult.setMsg("添加失败");
        } else if (addResult == 0) {
            stringResult.setMsg("添加成功");
        }
        return stringResult;

    }

    @ResponseBody
    @RequestMapping("addAdmin")
    public Result<String> addAdmin(User user) {

        int addResult = adminService.addAdmin(user);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(addResult);
        if (addResult == 1) {
            stringResult.setMsg("添加失败");
        } else if (addResult == 0) {
            stringResult.setMsg("添加成功");
        }
        return stringResult;

    }


    @ResponseBody
    @RequestMapping("adminLogin")
    public Result<String> adminLogin(String username, String password) {

        int loginResult = adminService.adminLogin(username, password);
        Result<String> stringResult = new Result<String>();

        switch (loginResult) {
            case 2:
                stringResult.setCode(2);
                stringResult.setMsg("密码错误");
                break;
            case 1:
                stringResult.setCode(1);
                stringResult.setMsg("没有此用户");
                break;
            case 0:
                stringResult.setCode(0);
                stringResult.setMsg("登录成功");
                break;
        }
        return stringResult;
    }

    @ResponseBody
    @RequestMapping("getTeacherByTid")
    public Result<Teacher> getTeacherByTid(int tid) {
        Teacher teacher = adminService.getTeacherByTid(tid);
        Result<Teacher> result = new Result<Teacher>();
        if (teacher == null) {
            result.setCode(1);
            result.setMsg("查询失败");
        } else {
            result.setCode(0);
            result.setMsg("查询成功");
        }
        result.setData(teacher);

        return result;
    }


    @ResponseBody
    @RequestMapping("modifyTeacherByTeacher")
    public Result<String> modifyTeacherByTeacher(Teacher teacher) {

        int modifyResult = adminService.modifyTeacherByTeacher(teacher);
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
    @RequestMapping("modifyClassInfoByClassInfo")
    public Result<String> modifyClassInfoByClassInfo(ClassInfo classInfo) {

        int modifyResult = adminService.modifyClassInfoByClassInfo(classInfo);
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
    @RequestMapping("deleteClassInfoByCid")
    public Result<String> deleteClassInfoByCid(int cid) {

        int modifyResult = adminService.deleteClassInfoByCid(cid);
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
    @RequestMapping("deleteTeacherByTid")
    public Result<String> deleteTeacherByTid(int tid) {

        int modifyResult = adminService.deleteTeacherByTid(tid);
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
    @RequestMapping("usernameIsExist")
    public Result<String> usernameIsExist(String username) {

        int modifyResult = adminService.usernameIsExist(username);
        Result<String> stringResult = new Result<String>();

        stringResult.setCode(modifyResult);
        if (modifyResult == 1) {
            stringResult.setMsg("用户名已存在，不可插入");
        } else if (modifyResult == 0) {
            stringResult.setMsg("可以插入");
        }
        return stringResult;
    }



}
