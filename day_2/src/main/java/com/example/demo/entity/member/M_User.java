package com.example.demo.entity.member;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * FileName:M_User
 * Author: kaishen
 * Date: 2020/11/2 12:30
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class M_User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//由数据库控制,auto是程序统一控制
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String mobile;
    private String password;
    private String cnname;

    private boolean Enabled;
    @Column(nullable = true)
    private String validataCode;
    @Column(nullable = true)
    private Integer followSize = 0;//关注数
    private Integer fanSize = 0; //粉丝数

    @Transient
    private Integer isFriend = 0;//关系，0表示没有关系，2表示互相关注
    @Column(nullable = true)
    private Long createTime;
    @Column(nullable = true)
    private Long lastModifyTime;
    @Column(nullable = true)
    private String outDate;
    @Column(nullable = true)
    private String active;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<M_UserRole> roles;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //根据自定义逻辑来返回用户权限，如果用户权限返回空或者和拦截路径对应权限不同，验证不通过
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grants = new ArrayList<>();
        List<M_UserRole> roles = this.getRoles();
        System.out.println("roles00000"+roles);
        for (M_UserRole role:roles
             ) {
            grants.add(new SimpleGrantedAuthority(role.getRolename()));
        }
        return grants;
    }

    @Override
    public String getUsername() {
        return this.name;
    }


}
