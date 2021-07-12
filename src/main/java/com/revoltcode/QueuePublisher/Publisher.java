package com.revoltcode.QueuePublisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main (String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        int i = 1;
        while(i<11) {
            String message = "My first rabbitMq message"+i;
            channel.basicPublish("", "Queue-1", null, message.getBytes());

            System.out.println("published "+i+" X");
            i++;
            Thread.sleep(2000);
        }
    }
}
