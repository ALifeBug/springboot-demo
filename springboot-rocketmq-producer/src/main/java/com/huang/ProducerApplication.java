package com.huang;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	@Override
	public void run(String... strings){
		rocketMQTemplate.convertAndSend("test-topic1","test message");
		rocketMQTemplate.convertAndSend("test-topic2",new OrderPaidEvent("1000",100));
	}
}

