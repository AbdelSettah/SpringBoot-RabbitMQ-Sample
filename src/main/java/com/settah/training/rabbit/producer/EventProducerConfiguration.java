package com.settah.training.rabbit.producer;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class EventProducerConfiguration {

	@Bean(name="eventExchange2")
	@Primary
	public Exchange eventExchange() {
		return new TopicExchange("eventExchange");
	}

	@Bean
	public Producer customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
		return new Producer(rabbitTemplate, eventExchange);
	}
}
