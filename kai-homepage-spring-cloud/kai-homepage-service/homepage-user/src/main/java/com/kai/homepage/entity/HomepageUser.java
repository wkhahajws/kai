package com.kai.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * FileName:HomepageUser
 * Author: kaishen
 * Date: 2020/11/9 16:12
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class HomepageUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    public HomepageUser(String name,String email){
        this.name = name;
        this.email = email;
    }
}
