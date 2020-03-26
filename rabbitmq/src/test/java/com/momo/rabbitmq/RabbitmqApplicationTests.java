package com.momo.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

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

}
