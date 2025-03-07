package com.example.demo.entity.sysuser;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * FileName:SysPermission
 * Author: kaishen
 * Date: 2020/10/22 14:23
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Data
@Entity
public class SysPermission {

    @Id
    @GeneratedValue
    private Integer id;
    //名称.
    private String name;
    @Column(columnDefinition="enum('menu','button')")
    //资源类型，[menu|button]
    private String resourceType;
    private String url;//资源路径.
    //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private String permission;
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;
    @Transient
    private List permissions;
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;
    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split("|"));
    }

    public void setPermissions(List permissions) {
        this.permissions = permissions;
    }

}
