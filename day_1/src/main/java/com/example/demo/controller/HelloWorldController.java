package com.example.demo.controller;

import com.example.demo.mq.CustomSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName:HelloWorldController
 * Author: kaishen
 * Date: 2020/9/5 15:15
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@RestController
public class HelloWorldController {
    @Autowired
    private CustomSender customSender;

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello,spring boot";
    }

    @RequestMapping("/test")
    public String test(){
        customSender.sendMessage("hello World");
        return "oooo";
    }
}
