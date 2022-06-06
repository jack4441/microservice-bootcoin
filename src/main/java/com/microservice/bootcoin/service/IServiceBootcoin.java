package com.microservice.bootcoin.service;

import com.microservice.bootcoin.entity.Bootcoin;
import com.microservice.bootcoin.entity.MobileWalletRedis;
import com.microservice.bootcoin.entity.PurchaseRequest;
import com.microservice.bootcoin.entity.RequestBootcoin;
import com.microservice.bootcoin.entity.RequestPurchaseRequest;
import com.microservice.bootcoin.entity.RequestTranferBootcoin;
import com.microservice.bootcoin.entity.TransferBootcoin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IServiceBootcoin {

	Flux<Iterable<MobileWalletRedis>> getAllMobileWalletRedis();
	Mono<Bootcoin> saveWalletBootcoin(RequestBootcoin request);
	Mono<PurchaseRequest> savePurchaseRequest(RequestPurchaseRequest request);
	Mono<TransferBootcoin> saveTransferBootcoin(RequestTranferBootcoin request);
	
}
