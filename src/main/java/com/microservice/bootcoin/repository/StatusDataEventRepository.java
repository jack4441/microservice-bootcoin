package com.microservice.bootcoin.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservice.bootcoin.entity.StatusDataEventRedis;

public interface StatusDataEventRepository extends CrudRepository<StatusDataEventRedis, String> {

}
