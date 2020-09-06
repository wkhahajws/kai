package com.example.demo.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:MyCustomConstraint
 * Author: kaishen
 * Date: 2020/9/6 16:59
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
//限定使用范围,只能使用在字段上
@Target({ElementType.FIELD})
//表明注解的生命周期，代码运行的时候可以通过反射获取到注解
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyCustomConstraintValidator.class)

public @interface MyCustomConstraint {
    String message() default "请输入我的真实姓名";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
