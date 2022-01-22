package com.example.httpdemo.service.impl;

import com.example.httpdemo.bean.Student;
import com.example.httpdemo.mapper.StudentMapper;
import com.example.httpdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }
}
