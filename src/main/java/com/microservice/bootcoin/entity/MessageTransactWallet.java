package com.microservice.bootcoin.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageTransactWallet implements Serializable {

private static final long serialVersionUID = -4204153980035193095L;
private String id;
private String idTransact;
private double amount;
//Referencia a la cuenta yanqui o a la cuenta bancaria del solicitante de compra.
private String iddetail;
private String number_destination;
private String destination;
private String status;

private String mobile_buyer;
private String mobile_seller;

public StatusDataEventRedis toStatusDataEventRedis() {
	return StatusDataEventRedis.builder()
			.id(this.id)
			.idTransact(this.idTransact)
			.mobile_buyer(mobile_buyer)
			.mobile_seller(mobile_seller)
			.typeEvent("TransactBootcoin")
			.status(this.status)
			.build();
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return "{\r\n"
			+ "    \"id\": \""+this.id+"\",\r\n"
			+ "    \"idTransact\": \""+this.idTransact+"\",\r\n"
			+ "    \"amount\": \""+this.amount+"\",\r\n"
			+ "    \"iddetail\": \""+this.iddetail+"\",\r\n"
			+ "    \"mobile_buyer\": \""+this.mobile_buyer+"\",\r\n"
			+ "    \"mobile_seller\": \""+this.mobile_seller+"\",\r\n"
			+ "    \"number_destination\": \""+this.number_destination+"\",\r\n"
			+ "    \"destination\": \""+this.destination+"\",\r\n"
			+ "    \"status\": \""+this.status+"\"\r\n"
			+ "}";
}

}
