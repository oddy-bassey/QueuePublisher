package com.revoltcode.QueuePublisher.dircetexchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String message = "This is tv message!";
        channel.basicPublish("Direct-Exchange", "tv", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
