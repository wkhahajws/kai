package com.example.demo.service;

import com.example.demo.entity.sysuser.SysUser;
import com.example.demo.repository.sysuser.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * FileName:SysSecurityService
 * Author: kaishen
 * Date: 2020/10/22 15:56
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
//@Service
public class SysSecurityService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = sysUserRepository.findByName(name);
        if (user == null) {

            throw new UsernameNotFoundException("用户名不存在");

        } else if (!user.getEnabled()) { //被锁定，无法登录
            throw new LockedException("用户被锁定");
        }
        System.out.println(user.getEnabled());
        return user;
    }
}
