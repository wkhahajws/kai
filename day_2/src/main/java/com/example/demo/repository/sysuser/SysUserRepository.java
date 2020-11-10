package com.example.demo.repository.sysuser;

import com.example.demo.entity.sysuser.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:SysUserRepository
 * Author: kaishen
 * Date: 2020/10/22 15:07
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByName(String name);
    SysUser findById(long id);
}
