package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Event {

    @RequestMapping(value = "test")
    public String test(Model model){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("小李",16,1));
        studentList.add(new Student("小王",20,3));
        studentList.add(new Student("小黑",18,0));
        model.addAttribute("studentList",studentList);
        model.addAttribute("name","张三");
        model.addAttribute("desc","欢迎你<h1>武汉<h1/>");
        return "success";
    }

    @RequestMapping(value = "name")
    @ResponseBody
    public String getName(){
        return "name";
    }

    @RequestMapping(value = "/{name}")
    public String getName(@PathVariable String name,Model model){
        model.addAttribute(name,name);
        return "success";
    }
}
