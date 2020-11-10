package com.kai.homepage.repository;

import com.kai.homepage.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:CourseRepository
 * Author: kaishen
 * Date: 2020/11/9 13:42
 * Description:
 */
public interface CourseRepository extends JpaRepository<Course,Long> {
}
