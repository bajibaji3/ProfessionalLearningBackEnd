package com.example.httpdemo.controller;

import com.example.httpdemo.bean.Student;
import com.example.httpdemo.service.StudentService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String getStudent() {
        List<Student> list = new ArrayList<>();
        Student student = new Student("Bob","111","5");
        Student student1 = new Student("Tom","111","5");
        list.add(student);
        list.add(student1);
        Gson gson = new Gson();
        String jsonStudents=gson.toJson(list);
        return jsonStudents;
    }

    @PostMapping("/register")
    public void doRegister(Student student) {
        studentService.addStudent(student);
    }

    @PostMapping("/testPost")
    public void testPost(Student student) {
        System.out.println("name-->" + student.getName());
    }
}
