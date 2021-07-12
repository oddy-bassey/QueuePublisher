package com.revoltcode.QueuePublisher.fanoutexchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {

    //NOTE: the consumers are the same as well.

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String message = "This is a fanout message!";
        channel.basicPublish("Fanout-Exchange", "", null, message.getBytes());

        channel.close();
        connection.close();
    }
}
