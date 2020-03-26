package com.momo.rabbitmq4.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Hut
 * @Date: 2020/03/20 15:40
 **/
@Configuration
public class RabbitConfig {

    public static final String TOPIC_QUEUE1="topic.queue1";
    public static final String TOPIC_QUEUE2="topic.queue2";
    public static final String TOPIC_EXCHANGE="topic.exchange";

    @Bean
    public Queue queue(){
        return new Queue(TOPIC_QUEUE1);
    }
    @Bean
    public Queue queue2(){
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with("lzc.message");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("lzc.#");
    }
}
