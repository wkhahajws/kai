package com.kai.homepage.service;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;

import java.util.List;

/**
 * FileName:ICourseService
 * Author: kaishen
 * Date: 2020/11/9 13:46
 * Description:
 */
public interface ICourseService {

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    CourseInfo getCourseInfo(long id);

    /**
     * 通过ids获取课程列表
     * @param request
     * @return
     */
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
