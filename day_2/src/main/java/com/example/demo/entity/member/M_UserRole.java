package com.example.demo.entity.member;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * FileName:M_UserRoleRepository
 * Author: kaishen
 * Date: 2020/11/2 12:40
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class M_UserRole {
    @Id
    @GeneratedValue
    private long id;
    private String rolename;
    private String cnname;
}
