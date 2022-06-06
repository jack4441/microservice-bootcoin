package com.microservice.bootcoin.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.bootcoin.entity.MobileWalletRedis;

public interface HistoryMovilWalletRepository extends CrudRepository<MobileWalletRedis, String> {

}
