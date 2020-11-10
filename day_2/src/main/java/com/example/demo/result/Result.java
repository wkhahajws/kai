package com.example.demo.result;

import lombok.Data;

/**
 * FileName:Result
 * Author: kaishen
 * Date: 2020/11/2 13:25
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Data
public class Result<T> {
    // 错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;
}
