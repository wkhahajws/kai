package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * FileName:JwtUserSecurityService
 * Author: kaishen
 * Date: 2020/10/27 21:32
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class JwtUserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        if (user == null) {
            User mobileUser = userRepository.findByMobile(name);
            if (mobileUser == null) {
                User emailUser= userRepository.findByEmail(name);
                if(emailUser==null)
                {  throw new UsernameNotFoundException("用户名邮箱手机号不存在!");
                }
                else{
                    user=userRepository.findByEmail(name);

                }
            }
            else {
                user = userRepository.findByMobile(name);
            }



        }
       /* else if("locked".equals(user.getStatus())) { //被锁定，无法登录
            throw new LockedException("用户被锁定");
        }*/
        return user;

    }
}
