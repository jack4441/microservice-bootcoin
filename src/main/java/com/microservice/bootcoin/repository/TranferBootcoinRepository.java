package com.microservice.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservice.bootcoin.entity.TransferBootcoin;

public interface TranferBootcoinRepository extends ReactiveMongoRepository<TransferBootcoin, String> {

}
