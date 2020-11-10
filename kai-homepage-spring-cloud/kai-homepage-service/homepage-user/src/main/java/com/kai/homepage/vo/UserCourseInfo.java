package com.kai.homepage.vo;

import com.kai.homepage.CourseInfo;
import com.kai.homepage.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * FileName:UserCourseInfo
 * Author: kaishen
 * Date: 2020/11/10 9:25
 * Description:用户课程信息对象定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCourseInfo {
    private UserInfo userInfo;
    private List<CourseInfo> courseInfos;

    public static UserCourseInfo invalid(){
        return new UserCourseInfo(
                UserInfo.invalid(), Collections.emptyList()
        );
    }
}
