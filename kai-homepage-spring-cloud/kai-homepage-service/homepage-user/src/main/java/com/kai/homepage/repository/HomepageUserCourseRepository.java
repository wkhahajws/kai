package com.kai.homepage.repository;

import com.kai.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * FileName:HomepageUserCourseRepository
 * Author: kaishen
 * Date: 2020/11/9 16:19
 * Description:
 */
public interface HomepageUserCourseRepository extends JpaRepository<HomepageUserCourse,Long> {
    List<HomepageUserCourse> findAllByUserId(long id);
}
