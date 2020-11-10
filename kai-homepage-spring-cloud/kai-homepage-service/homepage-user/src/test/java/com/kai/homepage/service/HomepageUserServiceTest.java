package com.kai.homepage.service;

import com.alibaba.fastjson.JSON;
import com.kai.homepage.Application;
import com.kai.homepage.UserInfo;
import com.kai.homepage.entity.HomepageUserCourse;
import com.kai.homepage.repository.HomepageUserCourseRepository;
import com.kai.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


/**
 * FileName:HomepageUserServiceTest
 * Author: kaishen
 * Date: 2020/11/10 10:47
 * Description:
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HomepageUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomepageUserCourseRepository homepageUserCourseRepository;

    @Test
    public void testCreateUser(){
        UserInfo userInfo = userService.createUser(new CreateUserRequest("jinwenshu", "18811491612@163.com"));
        System.out.println(JSON.toJSONString(userInfo));
    }


    @Test
    public void testGetUserInfo(){
        UserInfo userInfo = userService.getUserInfo(1L);
        System.out.println(JSON.toJSONString(userInfo));
    }

    @Test
    public void testCreateUserCourse(){
        HomepageUserCourse userCourse1 = new HomepageUserCourse();
        userCourse1.setUserId(1L);
        userCourse1.setCourseId(2L);

        HomepageUserCourse userCourse2 = new HomepageUserCourse();
        userCourse2.setUserId(1L);
        userCourse2.setCourseId(1L);
        int size = homepageUserCourseRepository.saveAll(Arrays.asList(userCourse1, userCourse2)).size();
        System.out.println(size);
    }

}
