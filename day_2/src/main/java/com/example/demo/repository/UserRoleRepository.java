package com.example.demo.repository;

import com.example.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:UserRoleRepository
 * Author: kaishen
 * Date: 2020/10/27 21:58
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    UserRole findByRolename(String rolename);
}
