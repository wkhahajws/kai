package com.kai.homepage.client;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * FileName:CourseClientHystrix
 * Author: kaishen
 * Date: 2020/11/10 9:16
 * Description:
 */
@Component
public class CourseClientHystrix implements CourseClient{

    @Override
    public CourseInfo getCourseInfo(long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
