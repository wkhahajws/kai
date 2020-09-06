package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:PropertiesTests
 * Author: kaishen
 * Date: 2020/9/5 16:23
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertiesTests {

    @Value("${myenvironment.name}")
    private String name;

    @Test
    public void getMyenvironment(){
        System.out.println(name);
    }
}
