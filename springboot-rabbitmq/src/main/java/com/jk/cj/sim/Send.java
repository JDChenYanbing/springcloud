package com.jk.cj.sim;

import com.jk.cj.UserBean;
import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String QUEUE_NAME = "simp_queue";

    public static void main(String[] args) throws IOException, TimeoutException {


        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        UserBean user =new UserBean();
        user.setId(1);
        user.setUserName("cuijian");
        user.setPassword("123");
        user.setPhone("13263371368");
        String message = "hello";
        channel.basicPublish("",QUEUE_NAME,null,user.toString().getBytes());
        //channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println("发送者"+user);

        channel.close();
        connection.close();

    }


}
