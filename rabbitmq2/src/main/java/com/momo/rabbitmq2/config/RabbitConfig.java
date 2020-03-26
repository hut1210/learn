package com.momo.rabbitmq2.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: Hut
 * @Date: 2020/03/20 11:26
 **/
@Configuration
public class RabbitConfig {

    public static final String DIRECT_QUEUE_NAME1="direct.queue1";
    public static final String DIRECT_EXCHANGE="direct.exchange";
    public static final String DIRECT_ROUTING_KEY="direct.pwl";
    public static final String DIRECT_ROUTING_KEY2="direct.info";
    public static final String DIRECT_QUEUE_NAME2="direct.queue2";
    public static final String DIRECT_EXCHANGE2="direct.exchange2";

    @Bean
    public Queue queue(){
        return new Queue(DIRECT_QUEUE_NAME1);
    }

    @Bean
    public Queue queue2(){
        return new Queue(DIRECT_QUEUE_NAME2);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public DirectExchange directExchange2(){
        return new DirectExchange(DIRECT_EXCHANGE2);
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(DIRECT_ROUTING_KEY);
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(directExchange()).with(DIRECT_ROUTING_KEY2);
    }

}
