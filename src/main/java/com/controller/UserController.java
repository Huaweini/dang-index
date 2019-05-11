package com.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.pojo.Teacher;
import com.pojo.User;
import com.service.TeacherService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;

    //学生管理
    @RequestMapping("/page")
    public String list(Model model, Page<User> page, String keyword) {
        //在查询之前需要调用，传入页码，以及每页的大小
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<User> list = userService.searchUser(keyword);
        //查询出来的数据，和连续显示的页数
        PageInfo res = new PageInfo(list, 5);
        model.addAttribute("page",res);
        model.addAttribute("keyword",keyword);
        return "user_list";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(User user) {
        userService.insert(user);
        return user;
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(User user) {
        userService.update(user);
        return user;
    }

    @RequestMapping("/editUserList")
    @ResponseBody
    public Object editUserList(User user) {
        return userService.selectById(user.getId());
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public Object delUser(User user) {
        return userService.del(user.getId());
    }

    //教师管理
    @RequestMapping("/teacherList")
    public String teacherList(){
        return "teacher_list";
    }

    @RequestMapping("/teacherPage")
    public String teacherPage(Model model, Page<User> page, String keyword){
        //在查询之前需要调用，传入页码，以及每页的大小
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List list = teacherService.searchTeacher(keyword);
        //查询出来的数据，和连续显示的页数
        PageInfo res = new PageInfo(list, 5);
        model.addAttribute("page",res);
        model.addAttribute("keyword",keyword);
        return "teacher_list";
    }

    @RequestMapping("/addTeacher")
    @ResponseBody
    public Object addTeacher(Teacher teacher) {
        teacherService.insert(teacher);
        return teacher;
    }

    @RequestMapping("/editTeacherList")
    @ResponseBody
    public Object editTeacherList(Teacher teacher) {
        return teacherService.selectById(teacher.getId());
    }

    @RequestMapping("/editTeacher")
    @ResponseBody
    public Object editTeacher(Teacher teacher) {
        teacherService.update(teacher);
        return teacher;
    }

    @RequestMapping("/delTeacher")
    @ResponseBody
    public Object delTeacher(Teacher teacher) {
        return teacherService.del(teacher.getId());
    }

}
