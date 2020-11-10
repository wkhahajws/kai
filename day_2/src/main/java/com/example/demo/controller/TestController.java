package com.example.demo.controller;

import com.example.demo.entity.U;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * FileName:TestController
 * Author: kaishen
 * Date: 2020/10/27 9:44
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

//@RestController
    @Controller
public class TestController {

    @RequestMapping(value = "/getparameter",method = RequestMethod.GET)
    public U getparameter(U u){
        return u;
    }

    @RequestMapping(value = "/getU1",method = RequestMethod.GET)
    public U u1(){
        U u = new U();
//        u.setId(100);
        u.setName("王九");
        u.setAge(52);
        return u;
    }

    @RequestMapping(value = "/postuser",method = RequestMethod.POST)
    public U postU(U u){
        System.out.println(u.getName());
        System.out.println(u.getAge());
        return u;
    }

    @RequestMapping(value = "/ccc")
    @ResponseBody
    public String loginSuccess(String name){
        return "welcome"+name;
    }

    @RequestMapping(path = "post",method = RequestMethod.POST)
    public String post(HttpServletRequest request,
                       @RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "age",required = false) Integer age,
                       @RequestParam(value = "id",required = false) Integer id){
        return "redirect:/ccc";
    }
}
