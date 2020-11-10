package com.kai.homepage.service;

import com.alibaba.fastjson.JSON;
import com.kai.homepage.Application;
import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import com.kai.homepage.entity.Course;
import com.kai.homepage.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * FileName:CourseServiceTests
 * Author: kaishen
 * Date: 2020/11/9 14:24
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceTests {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ICourseService courseService;

    @Test
    public void createCourseTest(){
        Course course1 = new Course("java",0,"abcdefg","java基础知识");
        Course course2 = new Course("c++",0,"abcdefg","c++基础知识");
        int size = courseRepository.saveAll(Arrays.asList(course1, course2)).size();
        System.out.println(size);
    }

    @Test
    public void selectCourseTest(){
        CourseInfo courseInfo = courseService.getCourseInfo(1L);
        CourseInfo courseInfo1 = courseService.getCourseInfo(3L);
        System.out.println(JSON.toJSONString(courseInfo));
        System.out.println(JSON.toJSONString(courseInfo1));
    }

    @Test
    public void selectCoursesTest(){
        System.out.println(courseService.getCourseInfos(new CourseInfosRequest(
                Arrays.asList(1L,2L)
        )));
    }
}
