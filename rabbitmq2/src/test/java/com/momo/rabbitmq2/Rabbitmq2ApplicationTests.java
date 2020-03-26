package com.momo.rabbitmq2;

import com.momo.rabbitmq2.config.RabbitConfig;
import com.momo.rabbitmq2.sender.DirectSender;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class Rabbitmq2ApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private DirectSender directSender;

    @Test
    void contextLoads() {
    }

    @Test
    void testSender() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            String content = "Date:" + new Date();
            //发送默认交换机对应的的队列pay
            amqpTemplate.convertAndSend("pay", content);
        }
    }

    @Test
    void testSender2() throws InterruptedException {
        /*while(true){
            Thread.sleep(1000);*/
            String content = "Date2:" + new Date();
            //发送默认交换机对应的的队列pay
            directSender.send(content);
        /*}*/
    }

}
