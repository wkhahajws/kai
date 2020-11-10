package com.kai.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import com.kai.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FileName:CourseController
 * Author: kaishen
 * Date: 2020/11/9 14:12
 * Description:
 */
@RestController
@Slf4j
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(long id){
        log.info("get-course---> {}",id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request){
        log.info("get courses --->{}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
