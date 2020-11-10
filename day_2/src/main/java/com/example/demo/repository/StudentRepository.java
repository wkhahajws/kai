package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:StudentRepository
 * Author: kaishen
 * Date: 2020/10/26 19:02
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
}
