package com.rabbit.demo.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.demo.config.MessagingConfig;
import com.rabbit.demo.entities.Purchase;
import com.rabbit.demo.entities.PurchaseStatus;

@RestController
@RequestMapping("/publish")
public class MessagePublisher {
		
	@Autowired
	private RabbitTemplate template;
	
	
	@PostMapping("/coupon")
	public String bookpurchase(@RequestBody Purchase purchase)
	{
		 purchase.setPurchase_id(UUID.randomUUID().toString());
		 PurchaseStatus status = new PurchaseStatus(purchase, "succesful", "purchase done successfully");
		 template.convertAndSend(MessagingConfig.exchange,MessagingConfig.routing_key,status);
		 return "Success";
	}
}
