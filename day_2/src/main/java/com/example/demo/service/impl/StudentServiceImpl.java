package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName:StudentServiceImpl
 * Author: kaishen
 * Date: 2020/10/26 19:06
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findStudentList() {
        List<Student> list = studentRepository.findAll();
        return list;
    }

    @Override
    public Student findStudentById(long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }
}
