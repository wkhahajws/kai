package com.example.demo.entity.sysuser;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * FileName:SysRole
 * Author: kaishen
 * Date: 2020/10/22 14:01
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Data
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    /**
     * 编号
     */
    private Integer id;
    private String cnname;  //角色名
    private String role;    //角色标识程序中判断使用,如"sys",这个是唯一的:
    private String description; //角色描述,UI界面显示使用
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;



    // 用户 - 角色关系定义;
    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="uid")})
    private List<SysUser> userInfos;// 一个角色对应多个用户
}
