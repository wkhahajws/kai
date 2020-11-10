package com.example.demo.repository.sysuser;

import com.example.demo.entity.sysuser.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:SysRoleRepository
 * Author: kaishen
 * Date: 2020/10/22 15:05
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface SysRoleRepository extends JpaRepository<SysRole,Long> {
    SysRole findByRole(String name);
}
