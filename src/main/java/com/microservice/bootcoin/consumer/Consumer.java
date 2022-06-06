package com.microservice.bootcoin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservice.bootcoin.Util;
import com.microservice.bootcoin.entity.MessageTransactWallet;
import com.microservice.bootcoin.repository.BootcoinRepository;
import com.microservice.bootcoin.repository.StatusDataEventRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Consumer {
	
	@Value( "${tasa.bootcoin.compra}" )
	private String tasacompra;
	@Value( "${tasa.bootcoin.venta}" )
	private String tasaventa;
	@Autowired
	BootcoinRepository bootcoinRepository;
	@Autowired
	StatusDataEventRepository dataEventdao;
	@KafkaListener(topics={"transferBootcoin"}, groupId="spring-boot-kafka")
	public void consume(String message) throws JsonProcessingException {
		MessageTransactWallet messageResult = Util.objectMapper.readValue(message, MessageTransactWallet.class);
		if(dataEventdao.findById(messageResult.getId()).isPresent())
		{
			if(messageResult.getStatus().equals("Success"))
				dataEventdao.deleteById(messageResult.getId());
			else
				log.info("Mensaje de transacción recibida pero no encontrada en los registros: " + messageResult.getId());
			var findBuyer = bootcoinRepository.findByMovil(messageResult.getMobile_buyer()).block();
			var findSeller = bootcoinRepository.findByMovil(messageResult.getMobile_seller()).block();
			var bootcoins = messageResult.getAmount()/Double.parseDouble(tasaventa);
			findBuyer.setCash_bootcoin(findBuyer.getCash_bootcoin()+bootcoins);
			bootcoinRepository.save(findBuyer).block();
			findSeller.setCash_bootcoin(findBuyer.getCash_bootcoin()-bootcoins);
			bootcoinRepository.save(findSeller).block();
			dataEventdao.deleteById(messageResult.getId());
		}
	}
	
	@KafkaListener(topics={"registerSelletBootcoin"}, groupId="spring-boot-kafka")
	public void consumeRegisterSeller(String message) throws JsonProcessingException {
		MessageTransactWallet messageResult = Util.objectMapper.readValue(message, MessageTransactWallet.class);
		if(dataEventdao.findById(messageResult.getId()).isPresent())
		{
			if(messageResult.getStatus().equals("SuccessSeller"))
				bootcoinRepository.findByDocid(messageResult.getDestination()).map(value -> value.changeValuePermission_sellerToTrue())
				.flatMap(bootcoinRepository::save).block();
			if(messageResult.getStatus().equals("FailedSeller"))
				log.info("Mensaje de transacción recibida pero no encontrada en los registros: " + messageResult.getId());
			dataEventdao.deleteById(messageResult.getId());
		}
	}
	
}
