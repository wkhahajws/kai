package com.kai.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * FileName:Course
 * Author: kaishen
 * Date: 2020/11/9 13:28
 * Description:课程实体
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseName;
    //0(免费课) 1(实战课)
    private Integer courseType;
    private String courseIcon;
    private String courseIntro;

    @CreatedDate
    private Long createTime;

    @LastModifiedDate
    private Long updateTime;

    public Course(String courseName,int courseType,String courseIcon,String courseIntro){
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    public static Course invalid(){
        Course course = new Course("", 0, "", "");
        course.setId(-1L);
        return course;
    }

}
