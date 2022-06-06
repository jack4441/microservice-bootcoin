package com.microservice.bootcoin;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class BootcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoinApplication.class, args);
	}
	
	@Bean
	NewTopic transferYanquiBootcoin() {
		return TopicBuilder.name("transferBootcoin").partitions(15).replicas(3).build();
	}
	
	@Bean
	NewTopic registerSelletBootcoin() {
		return TopicBuilder.name("registerSelletBootcoin").partitions(15).replicas(3).build();
	}
	
}
