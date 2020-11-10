package com.example.demo.mq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileName:CancelOrderSender
 * Author: kaishen
 * Date: 2020/11/3 22:51
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Component
public class CancelOrderSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queueName, Integer msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Sender:" + sdf.format(new Date()));
        rabbitTemplate.convertAndSend("delayed_exchange", queueName, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                int delay_time = 10000;
                message.getMessageProperties().setHeader("x-delay", delay_time);
                return message;
            }
        });
    }
}
