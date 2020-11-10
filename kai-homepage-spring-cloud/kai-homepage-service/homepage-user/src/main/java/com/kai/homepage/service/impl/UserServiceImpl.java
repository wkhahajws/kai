package com.kai.homepage.service.impl;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.CourseInfosRequest;
import com.kai.homepage.UserInfo;
import com.kai.homepage.client.CourseClient;
import com.kai.homepage.entity.HomepageUser;
import com.kai.homepage.entity.HomepageUserCourse;
import com.kai.homepage.repository.HomepageUserCourseRepository;
import com.kai.homepage.repository.HomepageUserRepository;
import com.kai.homepage.service.ICourseService;
import com.kai.homepage.service.IUserService;
import com.kai.homepage.vo.CreateUserRequest;
import com.kai.homepage.vo.UserCourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * FileName:UserServiceImpl
 * Author: kaishen
 * Date: 2020/11/10 9:49
 * Description:
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private HomepageUserRepository homepageUserRepository;
    @Autowired
    private CourseClient courseClient;
    @Autowired
    private HomepageUserCourseRepository homepageUserCourseRepository;
    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (request.invalid()){
            return UserInfo.invalid();
        }
        HomepageUser oldUser = homepageUserRepository.findByName(request.getName());
        if(oldUser != null){
            return UserInfo.invalid();
        }
        HomepageUser newUser = homepageUserRepository.save(new HomepageUser(request.getName(), request.getEmail()));
        return new UserInfo(newUser.getId(),newUser.getName(),newUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(long id) {
        Optional<HomepageUser> homepageUser = homepageUserRepository.findById(id);
        if(!homepageUser.isPresent()){
            return UserInfo.invalid();
        }
        HomepageUser user = homepageUser.get();
        return new UserInfo(user.getId(),user.getName(),user.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(long id) {

        Optional<HomepageUser> homepageUser = homepageUserRepository.findById(id);
        if(homepageUser == null){
            return UserCourseInfo.invalid();
        }
        HomepageUser user = homepageUser.get();
        UserInfo userInfo = new UserInfo(user.getId(),user.getName(),user.getEmail());
        List<HomepageUserCourse> homepageUserCourses = homepageUserCourseRepository.findAllByUserId(user.getId());
        if (CollectionUtils.isEmpty(homepageUserCourses)) {
           return new UserCourseInfo(userInfo, Collections.emptyList());
        }
        List<Long> list = homepageUserCourses.stream().map(HomepageUserCourse::getCourseId).collect(Collectors.toList());
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(new CourseInfosRequest(list));

        return new UserCourseInfo(userInfo,courseInfos);
    }
}
