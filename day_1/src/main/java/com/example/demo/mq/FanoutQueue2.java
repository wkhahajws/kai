package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FileName:FanoutQueue2
 * Author: kaishen
 * Date: 2020/9/11 21:45
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Component
@RabbitListener(queues = "fanoutQueue2")
public class FanoutQueue2 {
    @RabbitHandler
    public void process(String message){
        System.out.println("FanoutQueue2:"+message);
    }
}
