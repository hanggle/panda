package com.oskyhang.demo.work;

import com.oskyhang.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * description: <br/>
 * author: zh <br/>
 * date: 2018/4/5 <br/>
 */
public class Sender {
    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 100; i++) {

            String message = " " + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Send: " + message );
        }
        channel.close();
        connection.close();
    }
}
