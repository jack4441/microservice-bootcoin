package com.microservice.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservice.bootcoin.entity.PurchaseRequest;

public interface PurchaseRequestRepository extends ReactiveMongoRepository<PurchaseRequest, String> {

}
