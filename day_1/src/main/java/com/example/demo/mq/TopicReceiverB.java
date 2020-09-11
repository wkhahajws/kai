package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FileName:TopicReceiverB
 * Author: kaishen
 * Date: 2020/9/10 12:02
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
@RabbitListener(queues = "topic.b")
public class TopicReceiverB {
    @RabbitHandler
    public void process(String message){
        System.out.println("Topic ReceiverB:"+message);
    }
}
