package com.example.demo.entity.sysuser;

/**
 * FileName:SysUser
 * Author: kaishen
 * Date: 2020/10/20 14:47
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * 用户实体类，通过实现UserDetails接口实现认证及授权
 */
@Entity
public class SysUser implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    //unique = true 表示这个字段的值在这张表里不能重复
    //nullable=false 表示这个字段在保存时必须有值
    @Column(nullable = false,unique = true)
    private String name;

    private String password;
    private String cnname;

    private Boolean enabled = Boolean.TRUE;


    //多对多映射，用户角色
    @ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    private List<SysRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    //获取当前用户实例的password
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public SysUser(){

    }
    public SysUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //获取当前用户实例的name
    @Override
    public String getUsername() {
        return this.name;
    }

    //帐号是否不过期，false则验证不通过
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //帐号是否不锁定，false则验证不通过
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证是否不过期，false则验证不通过
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //该帐号是否启用，false则验证不通过
    @Override
    public boolean isEnabled() {
        return true;
    }
}
