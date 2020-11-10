package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * FileName:Student
 * Author: kaishen
 * Date: 2020/10/26 18:52
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class Student extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "enum('male','female')")
    private String sex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id")
    private Card card;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_student",joinColumns = {@JoinColumn(name="s_id")},inverseJoinColumns = {@JoinColumn(name="t_id")})
    @JoinColumn(name = "t_id")
    private Set<Teacher> teachers;

}
