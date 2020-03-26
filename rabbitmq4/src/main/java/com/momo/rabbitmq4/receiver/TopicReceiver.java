package com.momo.rabbitmq4.receiver;

import com.momo.rabbitmq4.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: Hut
 * @Date: 2020/03/20 15:52
 **/
@Component
public class TopicReceiver {
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(String message) {
        System.out.println("【receiveTopic1监听到消息】" + message);
    }
    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(String message) {
        System.out.println("【receiveTopic2监听到消息】" + message);
    }
}
