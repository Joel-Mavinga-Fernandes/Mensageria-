package com.example.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.message.Message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Consumidor {
	
		public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		//channel.queueDeclare("Queue-1", false, false, false, null);
		
		channel.basicConsume("Queue-1", true, (consumerTag, message) -> {
			String m = new String (message.getBody(), "UTF-8");
			System.out.println("Mensagem recebida = " + m);
		}, consumerTag -> {});
		
		
			
		

}
}