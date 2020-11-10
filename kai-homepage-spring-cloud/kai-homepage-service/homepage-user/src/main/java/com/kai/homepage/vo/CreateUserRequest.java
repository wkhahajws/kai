package com.kai.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * FileName:CreateUserRequest
 * Author: kaishen
 * Date: 2020/11/10 9:21
 * Description:创建用户请求对象定义
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String name;
    private String email;

    public boolean invalid(){
        return StringUtils.isEmpty(name) && StringUtils.isEmpty(email);
    }
}
