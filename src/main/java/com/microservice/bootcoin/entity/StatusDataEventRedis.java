package com.microservice.bootcoin.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RedisHash("StatusDataEvent")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StatusDataEventRedis implements Serializable {
	
private static final long serialVersionUID = 5183492578834998618L;
private String id;
private String idTransact;
private String mobile_buyer;
private String mobile_seller;
private String typeEvent;
private String status;

}
