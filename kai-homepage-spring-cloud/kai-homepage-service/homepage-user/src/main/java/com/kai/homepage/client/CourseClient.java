package com.kai.homepage.client;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * FileName:CourseClient
 * Author: kaishen
 * Date: 2020/11/10 9:08
 * Description:
 */
@FeignClient(value = "eurake-client-homepage-course",fallback = CourseClientHystrix.class)
public interface CourseClient {

    @RequestMapping(value = "/homepage-course/get/course",method = RequestMethod.GET)
    CourseInfo getCourseInfo(long id);

    @RequestMapping(value = "/homepage-course/get/courses",method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
