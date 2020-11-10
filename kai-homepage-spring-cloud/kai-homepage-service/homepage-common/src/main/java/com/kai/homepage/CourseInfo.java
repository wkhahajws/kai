package com.kai.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName:CourseInfo
 * Author: kaishen
 * Date: 2020/11/9 12:01
 * Description:课程信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseInfo {
    private Long id;
    private String courseName;
    private String courseType;
    private String courseIcon;
    private String courseIntro;

    public static CourseInfo invalid(){
        return new CourseInfo(-1L,"","","","");
    }

}
