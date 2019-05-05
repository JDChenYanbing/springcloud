package com.jk.cj.test2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_1")
public class Receive1 {

    @RabbitHandler
    public void process(String hello){
        System.out.println("接收者1:" + hello);
    }
}
