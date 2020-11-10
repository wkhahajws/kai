package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * FileName:StudentService
 * Author: kaishen
 * Date: 2020/10/26 19:04
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface StudentService {
    public List<Student> findStudentList();
    public Student findStudentById(long id);
}
