package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * FileName:Teacher
 * Author: kaishen
 * Date: 2020/10/26 19:42
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Entity
@Data
public class Teacher extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private School school;

    @ManyToMany
    @JoinTable(name = "teacher_student",joinColumns = {@JoinColumn(name = "t_id")},inverseJoinColumns = {@JoinColumn(name = "s_id")})
    @JoinColumn(name = "s_id")
    private Set<Student> students;
}
