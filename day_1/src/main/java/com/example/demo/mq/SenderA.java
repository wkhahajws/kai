package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FileName:SenderA
 * Author: kaishen
 * Date: 2020/9/7 19:02
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
public class SenderA {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String context){
        System.out.println("sender:"+context);
        //使用AmqpTemplate将消息发送到消息队列QueueHello中去
        this.amqpTemplate.convertAndSend("Queue1",context);
    }
}
