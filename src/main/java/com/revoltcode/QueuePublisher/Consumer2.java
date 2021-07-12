package com.revoltcode.QueuePublisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        int i = 1;
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
          String message = new String (delivery.getBody());
          System.out.println("Message Recieved = "+message);

        };
        channel.basicConsume("Queue-1",true, deliverCallback, consumerTag -> {});
    }
}