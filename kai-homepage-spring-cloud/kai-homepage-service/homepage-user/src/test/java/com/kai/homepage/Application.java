package com.kai.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * FileName:Application
 * Author: kaishen
 * Date: 2020/11/10 10:44
 * Description:
 */

@EnableFeignClients(basePackages = {"com.kai.homepage"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
