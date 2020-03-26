package com.momo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author: Hut
 * @Date: 2020/03/20 9:40
 **/
@Configuration
public class RabbitMqConfig {

    public static final String QUEUE_NAME="pay";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }
}
