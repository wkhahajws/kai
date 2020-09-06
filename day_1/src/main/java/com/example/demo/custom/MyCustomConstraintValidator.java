package com.example.demo.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * FileName:MyCustomConstraintValidator
 * Author: kaishen
 * Date: 2020/9/6 17:14
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
public class MyCustomConstraintValidator implements ConstraintValidator<MyCustomConstraint,String> {
    @Override
    public void initialize(MyCustomConstraint myCustomConstraint) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(!s.equals("王凯")){
            return false;
        }
        return true;
    }
}
