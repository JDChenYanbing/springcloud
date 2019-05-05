package com.jk.cj.work;

import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        channel.basicQos(1);

        for (int i=0;i<50;i++){
            String message = "hello"+i;
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("发送者"+message);
        }


        channel.close();
        connection.close();

    }

}
