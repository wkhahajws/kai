package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

/**
 * FileName:UserServiceImpl
 * Author: kaishen
 * Date: 2020/10/20 0:44
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Service
public class UserServiceImpl implements UserService{

    @Override
    public String addUser() {
        System.out.println("addUser");
        return null;
    }

    @Override
    @RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
    public String deleteUser() {
        System.out.println("deleteUser");
        return null;
    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public String updateUser() {
        System.out.println("updateUser");
        return null;
    }
}
