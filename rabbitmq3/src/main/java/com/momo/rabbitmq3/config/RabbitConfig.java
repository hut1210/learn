package com.momo.rabbitmq3.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: Hut
 * @Date: 2020/03/20 14:26
 **/
@Configuration
public class RabbitConfig {

    public static final String FANOUT_QUEUE1="fanout.queue1";
    public static final String FANOUT_QUEUE2="fanout.queue2";
    public static final String FANOUT_EXCHANGE="fanout.exchange";

    @Bean
    public Queue queue1(){
        return new Queue(FANOUT_QUEUE1);
    }

    @Bean
    public Queue queue2(){
        return new Queue(FANOUT_QUEUE2);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
}
