package com.example.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class Produtor {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		try (Connection connection = factory.newConnection()) {
		Channel channel = connection.createChannel();
		//channel.queueDeclare("Queue-1", false, false, false, null);
		
		String message = " Segunda mensagem com RabbitMQ " + LocalDateTime.now();
		
		channel.basicPublish("", "Queue-1", false, null, message.getBytes());
		
		
		System.out.println("Mensagem enviada com sucesso");
		
		}
		
		

	}

}
