package com.momo.rabbitmq4.sender;

import com.momo.rabbitmq4.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 15:54
 **/
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    // 第一个参数：TopicExchange名字
    // 第二个参数：Route-Key
    // 第三个参数：要发送的内容
    public void send() {
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "lzc.message", "message");
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "lzc.lzc", "lzc");
    }
}
