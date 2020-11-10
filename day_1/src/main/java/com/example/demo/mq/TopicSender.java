package com.example.demo.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FileName:TopicSender
 * Author: kaishen
 * Date: 2020/9/11 9:48
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "topic";
        System.out.println("Sender:"+context);
        //第一个参数是交换机，第二个参数是Routing key,第三个是消息
        this.amqpTemplate.convertAndSend("topicExchange","topic.1",context);
    }

    public void send2(){
        String context = "topic.2";
        System.out.println("Sender:"+context);
        //第一个参数是交换机，第二个参数是Routing key,第三个是消息
        this.amqpTemplate.convertAndSend("topicExchange","topic.a",context);
    }

    public void send3(){
        String context = "topic.3";
        System.out.println("Sender:"+context);
        //第一个参数是交换机，第二个参数是Routing key,第三个是消息
        this.amqpTemplate.convertAndSend("topicExchange","topic.b",context);
    }
}
