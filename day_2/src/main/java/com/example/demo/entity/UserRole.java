package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * FileName:UserRole
 * Author: kaishen
 * Date: 2020/10/27 21:43
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class UserRole {
    @Id
    @GeneratedValue
    private long id;

    private String rolename;
    private String cnname;
}
