package com.example.demo.service;

import com.example.demo.entity.member.M_User;
import com.example.demo.repository.member.M_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * FileName:M_UserSecurityService
 * Author: kaishen
 * Date: 2020/11/3 14:38
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class M_UserSecurityService implements UserDetailsService {

    @Autowired
    private M_UserRepository m_userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        M_User m_user = m_userRepository.findByName(name);
        if(m_user == null){
            m_user = m_userRepository.findByMobile(name);
            if(m_user == null){
                m_user= m_userRepository.findByEmail(name);
                if(m_user == null){
                    throw new UsernameNotFoundException("用户名邮箱手机不存在");
                }
            }
        }else if("locked".equals(m_user.getActive())){
            throw new LockedException("用户被锁定");
        }
        return m_user;
    }
}
