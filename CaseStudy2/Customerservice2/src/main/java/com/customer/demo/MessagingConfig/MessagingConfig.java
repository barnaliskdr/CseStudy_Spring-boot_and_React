package com.customer.demo.MessagingConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
	
	
	public static final String queue = "my queue";
	public static final String exchange = "my queue exchange";
	public static final String routing_key = "my queue" ;
	
	
	@Bean
	public Queue queue()
	{
		return new Queue(queue);
	}
	
	
	@Bean
	public TopicExchange excange()
	{
		return new TopicExchange(exchange);
	}
	
	@Bean
	public Binding binding(Queue queue, TopicExchange exchange)
	{
		return BindingBuilder.bind(queue).to(exchange).with(routing_key);
	}
	
	@Bean
	public MessageConverter converter()
	{
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate template(ConnectionFactory connectionfactory)
	{
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionfactory);
		rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
	}
}
