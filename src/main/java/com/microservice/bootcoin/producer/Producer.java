package com.microservice.bootcoin.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Producer {
	private final KafkaTemplate<Integer, String> kafkaTemplate;
	public void publisMessageTransfer(String message) {
		Mono.just(kafkaTemplate.send("transferYanquiBootcoin", 45, message));
	}
	public void publisMessageBootcoin(String message) {
		Mono.just(kafkaTemplate.send("registerBootcoin", 45, message));
	}
}
