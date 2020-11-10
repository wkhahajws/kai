package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:HelloWorldController
 * Author: kaishen
 * Date: 2020/10/27 11:30
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
public class HelloWorldController {

    @ApiOperation(value = "hello",notes = "notes")
    @RequestMapping("/hello")
    public String hello() throws Exception{
        return "HelloWorld,Spring Boot!";
    }
}
