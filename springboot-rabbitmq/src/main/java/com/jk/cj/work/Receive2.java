package com.jk.cj.work;

import com.jk.cj.util.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive2 {

    private static final String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        channel.basicQos(1);

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String s = new String(body, "utf-8");
                System.out.println("接收者2" + s);

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }

            }
        };

        Boolean falg = false;
        channel.basicConsume(QUEUE_NAME, falg, defaultConsumer);


    }
}
