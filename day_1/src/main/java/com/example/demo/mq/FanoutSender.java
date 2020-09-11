package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FileName:FanoutSender
 * Author: kaishen
 * Date: 2020/9/11 21:47
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String message = "Hello World";
        amqpTemplate.convertAndSend("fanoutExchange","",message);
    }

}
