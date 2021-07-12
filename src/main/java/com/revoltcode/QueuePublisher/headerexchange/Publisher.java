package com.revoltcode.QueuePublisher.headerexchange;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Publisher {

    //NOTE: the consumers are the same as well.

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        Map<String, Object> headersMap = new HashMap<>();
        headersMap.put("item1", "mobile");
        headersMap.put("item2", "television");

        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().headers(headersMap).build();

        String message = "This is a message!";
        channel.basicPublish("Headers-Exchnage", "", basicProperties, message.getBytes());

        channel.close();
        connection.close();
    }
}
