package com.example.demo.controller;

import com.example.demo.entity.U;
import com.example.demo.service.UService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * FileName:RedisController
 * Author: kaishen
 * Date: 2020/10/28 23:55
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@RestController
@RequestMapping("/u")
public class RedisController {
    @Autowired
    UService uService;

    @RequestMapping("/{id}")
    public U ForTest(@PathVariable String id){
        U u = uService.selectU(id);
        return u;
    }

    @RequestMapping( "/update/")
    public String update(U u){
        uService.updataById(u);
        return "success";
    }


    @RequestMapping( "/delete/{id}")
    public String delete (@PathVariable String id){
        uService.deleteById(id);
        return "delete success";
    }


    @RequestMapping("/queryAll")
    public List<U> queryAll(){
        List<U> uList = uService.queryAll();
        return uList;
    }
}
