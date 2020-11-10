package com.example.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * FileName:logTest
 * Author: kaishen
 * Date: 2020/9/20 22:06
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class logTest {
    private Logger logger = LoggerFactory.getLogger(logTest.class);

    @Scheduled(fixedRate = 1000)
    @Test
    public void logtest(){
        logger.trace("trace 日志");
        logger.debug("debug 日志");
        logger.info("info 日志");
        logger.warn("warn 日志");
        logger.error("error 日志");
        System.out.println("1111111111111111111");
    }
}
