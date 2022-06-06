package com.microservice.bootcoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.bootcoin.entity.Bootcoin;
import com.microservice.bootcoin.entity.MobileWalletRedis;
import com.microservice.bootcoin.entity.PurchaseRequest;
import com.microservice.bootcoin.entity.RequestBootcoin;
import com.microservice.bootcoin.entity.RequestPurchaseRequest;
import com.microservice.bootcoin.entity.RequestTranferBootcoin;
import com.microservice.bootcoin.entity.TransferBootcoin;
import com.microservice.bootcoin.producer.Producer;
import com.microservice.bootcoin.repository.BootcoinRepository;
import com.microservice.bootcoin.repository.HistoryMovilWalletRepository;
import com.microservice.bootcoin.repository.PurchaseRequestRepository;
import com.microservice.bootcoin.repository.StatusDataEventRepository;
import com.microservice.bootcoin.repository.TranferBootcoinRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceBootcoin implements IServiceBootcoin {

	@Autowired
	BootcoinRepository bootcoinRepository;
	@Autowired
	PurchaseRequestRepository purchaseRequestRepository;
	@Autowired
	TranferBootcoinRepository tranferBootcoinRepository;
	@Autowired
	StatusDataEventRepository statusDataEventRepository;
	@Autowired
	HistoryMovilWalletRepository historyMovilWalletRepository;
	
	@Autowired
	Producer producer;
	
	@Override
	public Mono<Bootcoin> saveWalletBootcoin(RequestBootcoin request) {
		// TODO Auto-generated method stub
		if(request.getBootcoin().getId()==null)
			return bootcoinRepository.save(request.toBootcoin()).doOnSuccess(value-> {
				var param = value.toMessageTransactWallet();
				producer.publisMessageBootcoin(param.toString());
				statusDataEventRepository.save(param.toStatusDataEventRedis());
			});
		else
			return Mono.just(Bootcoin.builder().build());
	}

	@Override
	public Mono<PurchaseRequest> savePurchaseRequest(RequestPurchaseRequest request) {
		// TODO Auto-generated method stub
		if(request.getPurchaseRequest().getId()==null)
			return purchaseRequestRepository.save(request.toPurchaseRequest());
		else
			return Mono.just(PurchaseRequest.builder().build());
	}

	@Override
	public Mono<TransferBootcoin> saveTransferBootcoin(RequestTranferBootcoin request) {
		// TODO Auto-generated method stub
		if(request.getTransferBootcoin().getId()==null && request.getTransferBootcoin().isPermission_seller())
			return tranferBootcoinRepository.save(request.toTransferBootcoin()).doOnSuccess(value-> {
				producer.publisMessageTransfer(value.toMessageTransactWallet().toString());
				statusDataEventRepository.save(value.toMessageTransactWallet().toStatusDataEventRedis());
			});
		else
			return Mono.just(TransferBootcoin.builder().build());
	}

	@Override
	public Flux<Iterable<MobileWalletRedis>> getAllMobileWalletRedis() {
		// TODO Auto-generated method stub
		return Flux.just(historyMovilWalletRepository.findAll());
	}

}
