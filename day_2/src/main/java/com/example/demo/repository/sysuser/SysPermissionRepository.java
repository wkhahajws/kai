package com.example.demo.repository.sysuser;

import com.example.demo.entity.sysuser.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * FileName:SysPermissionRepository
 * Author: kaishen
 * Date: 2020/10/22 15:08
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public interface SysPermissionRepository extends JpaRepository<SysPermission,Long> {
    SysPermission findById(long id);
}
