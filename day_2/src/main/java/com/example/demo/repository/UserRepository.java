package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:UserRepository
 * Author: kaishen
 * Date: 2020/10/27 21:48
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByMobile(String mobile);
    User findByEmail(String email);
}
