package com.momo.rabbitmq5.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: Hut
 * @Date: 2020/03/23 10:18
 **/
@Configuration
public class RabbitConfig {

    public static final String ORDER_QUEUE_NAME="order.queue";
    public static final String EXCHANGE="direct.exchange";
    public static final String ORDER_ROUTING_KEY="order.routing.key";

    @Bean
    public Queue queue(){
        return new Queue(ORDER_QUEUE_NAME);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(ORDER_ROUTING_KEY);
    }
}
