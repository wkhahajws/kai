package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName:RabbitConfig
 * Author: kaishen
 * Date: 2020/11/3 13:44
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue regQueue(){
        return new Queue("reg_email");
    }


    @Bean
    public CustomExchange delayExchange(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("x-delayed-type","direct");
        return new CustomExchange("delayed_exchange","x-delayed-message",true,false,map);
    }

    @Bean
    public Queue queue(){
        Queue queue = new Queue("delay_queue_1", true);
        return queue;
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(delayExchange()).with("delay_queue_1").noargs();
    }
}
