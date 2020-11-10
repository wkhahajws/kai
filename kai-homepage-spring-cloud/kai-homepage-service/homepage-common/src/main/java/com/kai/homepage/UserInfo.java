package com.kai.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * FileName:UserInfo
 * Author: kaishen
 * Date: 2020/11/9 12:04
 * Description:用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private Long id;
    private String name;
    private String email;

    public static UserInfo invalid(){
        return new UserInfo(-1L,"","");
    }
}
