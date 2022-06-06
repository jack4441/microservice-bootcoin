package com.microservice.bootcoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.bootcoin.entity.Bootcoin;
import com.microservice.bootcoin.entity.MobileWalletRedis;
import com.microservice.bootcoin.entity.PurchaseRequest;
import com.microservice.bootcoin.entity.RequestBootcoin;
import com.microservice.bootcoin.entity.RequestPurchaseRequest;
import com.microservice.bootcoin.entity.RequestTranferBootcoin;
import com.microservice.bootcoin.entity.TransferBootcoin;
import com.microservice.bootcoin.service.IServiceBootcoin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("bootcoin/v1")
public class ControllerBootcoin {
	@Autowired
	IServiceBootcoin serviceBootcoin;
	
	@GetMapping(path="/getwalletredis", produces = MediaType.APPLICATION_JSON_VALUE)
	public Flux<Iterable<MobileWalletRedis>> getAllMobileWalletRedis(){
		return serviceBootcoin.getAllMobileWalletRedis();
	}
	@PostMapping(path = "/savebootcoin", produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Bootcoin> saveBootcoin(@RequestBody RequestBootcoin request){
		return serviceBootcoin.saveWalletBootcoin(request);
	}
	@PostMapping(path = "/savepurchase", produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<PurchaseRequest> savePurchaseRequest(@RequestBody RequestPurchaseRequest request){
		return serviceBootcoin.savePurchaseRequest(request);
	}
	
	@PostMapping(path = "/savetranfer", produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<TransferBootcoin> saveTransferBootcoin(@RequestBody RequestTranferBootcoin request){
		return serviceBootcoin.saveTransferBootcoin(request);
	}
	
}
