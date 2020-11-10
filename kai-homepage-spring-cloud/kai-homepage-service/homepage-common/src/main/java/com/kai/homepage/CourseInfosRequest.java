package com.kai.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * FileName:CourseInfosRequest
 * Author: kaishen
 * Date: 2020/11/9 12:08
 * Description:课程信息请求对象定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInfosRequest {
    private List<Long> ids;
}
