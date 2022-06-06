package com.microservice.bootcoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.microservice.bootcoin.entity.Bootcoin;

import reactor.core.publisher.Mono;

public interface BootcoinRepository extends ReactiveMongoRepository<Bootcoin, String> {

	Mono<Bootcoin> findByDocid(String docid);
	Mono<Bootcoin> findByMovil(String movil);
}
