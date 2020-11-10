package com.kai.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.kai.homepage.UserInfo;
import com.kai.homepage.service.IUserService;
import com.kai.homepage.vo.CreateUserRequest;
import com.kai.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:HomepageUserController
 * Author: kaishen
 * Date: 2020/11/10 10:34
 * Description:
 */
@RestController
@Slf4j
public class HomepageUserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request){
        log.info("create user -->{}", JSON.toJSONString(request));
        UserInfo userInfo = userService.createUser(request);
        return userInfo;
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(long id){
        log.info("getUserInfo -->{}", id);
        UserInfo userInfo = userService.getUserInfo(id);
        return userInfo;
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(long id){
        log.info("getUserCourseInfo -->{}", id);
        UserCourseInfo userCourseInfo = userService.getUserCourseInfo(id);
        return userCourseInfo;
    }


}
