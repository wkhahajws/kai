package com.example.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * FileName:RabbitmqConfig
 * Author: kaishen
 * Date: 2020/9/7 17:55
 * Description:${DESCRIPTION}
 * History:
 * <author> <time>  <version> <desc>
 * 作者姓名  修改时间  版本号    描述
 */

@Configuration
public class RabbitmqConfig {
    @Bean
    public Queue queue(){
        return new Queue("Queue1");
    }

    @Bean
    public Queue userQueue(){
        return new Queue("UserQueue1");
    }

    @Bean
    public Queue queueMessage(){
        return new Queue("topic.a");
    }

    @Bean
    public Queue queueMessage1(){
        return new Queue("topic.b");
    }


    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.a");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessage1,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.#");
    }

    @Bean
    public Queue fanoutQueueMessage1(){
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Queue fanoutQueueMessage2(){
        return new Queue("fanoutQueue2");
    }

    @Bean
    FanoutExchange exchange2(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutMessage(Queue fanoutQueueMessage1,FanoutExchange exchange2){
        return BindingBuilder.bind(fanoutQueueMessage1).to(exchange2);
    }

    @Bean
    Binding bindingFanoutMessages(Queue fanoutQueueMessage2,FanoutExchange exchange2){
        return BindingBuilder.bind(fanoutQueueMessage2).to(exchange2);
    }


    @Bean
    public Queue queue3(){
        return new Queue("delay_queue_1",true);
    }


    @Bean
    public CustomExchange delayExchange(){
        Map<String, Object> map = new HashMap<>();
        map.put("x-delayed-type","direct");
        return new CustomExchange("delayed_exchange","x-delayed-message",true,false,map);
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue3()).to(delayExchange()).with("delay_queue_1").noargs();
    }

}
