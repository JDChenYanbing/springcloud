package com.jk.cj.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "message")
public class Receive {

    @RabbitHandler
    public void process(String hello){
        System.out.println("接收者:" + hello);
    }
}
