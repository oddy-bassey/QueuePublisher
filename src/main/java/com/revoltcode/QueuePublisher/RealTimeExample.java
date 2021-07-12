package com.revoltcode.QueuePublisher;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RealTimeExample {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("from_date", "01-06-2021");
        jsonObject.put("to_date", "01-06-2021");
        jsonObject.put("email", "oddybassey@gmail.com");
        jsonObject.put("query", "select *");

        channel.basicPublish("", "Queue-1", null, jsonObject.toString().getBytes());
        channel.close();
        connection.close();
    }
}
