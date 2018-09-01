package com.example.springrabbitdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(OrderMessageListener.class);
	
	@RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void processOrder(Order order) {
        LOG.info("Order Received: " + order);
    }
	
}
