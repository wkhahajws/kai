package com.kai.homepage.service;

import com.kai.homepage.UserInfo;
import com.kai.homepage.vo.CreateUserRequest;
import com.kai.homepage.vo.UserCourseInfo;

/**
 * FileName:IUserService
 * Author: kaishen
 * Date: 2020/11/10 9:45
 * Description:
 */
public interface IUserService {

    /**
     * 创建用户
     * @param request
     * @return
     */
    UserInfo  createUser(CreateUserRequest request);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    UserInfo getUserInfo(long id);


    /**
     * 获取用户课程信息
     */
    UserCourseInfo getUserCourseInfo(long id);
}
