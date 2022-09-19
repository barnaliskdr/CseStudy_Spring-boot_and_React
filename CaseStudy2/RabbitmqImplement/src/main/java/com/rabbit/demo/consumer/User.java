package com.rabbit.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbit.demo.config.MessagingConfig;
import com.rabbit.demo.entities.PurchaseStatus;

@Component
public class User {
	
	@RabbitListener(queues = MessagingConfig.queue)
	public void ConsumeMessageFromQueue(PurchaseStatus purchasestatus)
	{
		System.out.println("Received message from company: "+purchasestatus);
	}
}
