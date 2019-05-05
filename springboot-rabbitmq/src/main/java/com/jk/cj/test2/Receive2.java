package com.jk.cj.test2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic_2")
public class Receive2 {

    @RabbitHandler
    public void process(String hello){
        System.out.println("接收者2:" + hello);
    }
}
