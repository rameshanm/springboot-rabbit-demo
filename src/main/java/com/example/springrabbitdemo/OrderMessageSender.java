package com.example.springrabbitdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderMessageSender {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderMessageSender.class);
	
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order) {
    	LOG.info("Order to be converted and send to the Queue" + order);
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, order);
    }
}