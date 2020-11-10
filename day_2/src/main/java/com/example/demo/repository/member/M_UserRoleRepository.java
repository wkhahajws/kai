package com.example.demo.repository.member;

import com.example.demo.entity.member.M_UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:M_UserRoleRepository
 * Author: kaishen
 * Date: 2020/11/2 13:31
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface M_UserRoleRepository extends JpaRepository<M_UserRole,Long> {
    M_UserRole findByRolename(String name);

}
