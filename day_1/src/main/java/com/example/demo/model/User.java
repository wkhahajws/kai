package com.example.demo.model;

import com.example.demo.custom.MyCustomConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * FileName:User
 * Author: kaishen
 * Date: 2020/9/6 13:10
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Data
public class User {
    private long id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5,max = 20,message = "用户名长度为5-20个字符")
    private String name;

    @NotNull
    @Min(value = 18,message = "年龄不能小于 18 岁")
    @Max(value = 60,message = "年龄不能大于 60 岁")
    private Integer age;

    @Email(message = "请输入邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;       //邮箱

    @MyCustomConstraint
    private String answer;       //答案

}
