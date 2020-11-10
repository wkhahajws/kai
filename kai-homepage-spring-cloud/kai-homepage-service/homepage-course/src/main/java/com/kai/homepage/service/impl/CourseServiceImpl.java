package com.kai.homepage.service.impl;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import com.kai.homepage.entity.Course;
import com.kai.homepage.repository.CourseRepository;
import com.kai.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * FileName:CourseServiceImpl
 * Author: kaishen
 * Date: 2020/11/9 13:55
 * Description:
 */
@Service
@Slf4j
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseInfo getCourseInfo(long id) {
        Optional<Course> course = courseRepository.findById(id);
        CourseInfo courseInfo = buildCourseInfo(course.orElse(Course.invalid()));
        return courseInfo;
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {

        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }
        List<Course> courses = courseRepository.findAllById(request.getIds());

        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());
    }

    /**
     * 根据数据记录构造对象信息
     * @param course
     * @return
     */
    private CourseInfo buildCourseInfo(Course course){
        return CourseInfo.builder().id(course.getId()).courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "收费课程")
                .courseIcon(course.getCourseIcon()).courseIntro(course.getCourseIntro()).build();
    }
}
