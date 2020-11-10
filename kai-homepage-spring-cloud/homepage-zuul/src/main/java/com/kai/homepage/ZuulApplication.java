package com.kai.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * FileName:ZuulApplication
 * Author: kaishen
 * Date: 2020/11/7 22:07
 * Description:
 * EnableZuulProxy：标注当前应用是 Zuul Server
 * SpringCloudApplication：用于简化配置的组合注解
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }
}
