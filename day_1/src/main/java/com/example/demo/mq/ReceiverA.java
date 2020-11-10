package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FileName:ReceiverA
 * Author: kaishen
 * Date: 2020/9/7 18:58
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
@RabbitListener(queues = "Queue1")
public class ReceiverA {
    //RabbitHandler来实现具体消费
    @RabbitHandler
    public void QueueReceiver(String Queue1){
        System.out.println("ReceiverA:" + Queue1);
    }
}
