package com.microservice.bootcoin.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document("bootcoin")
@Data
@Builder
public class Bootcoin implements Serializable {
	
private static final long serialVersionUID = -8615551894745571712L;
@Id
private String id;
@Field
private String docid;
@Field
private String movil;
@Field
private double cash_bootcoin;
@Field
private String email;
@Field
private boolean permission_seller;

public MessageTransactWallet toMessageTransactWallet()
{
	
return MessageTransactWallet.builder()
.id(UUID.randomUUID().toString())
.idTransact(UUID.randomUUID().toString())
.amount(0.00)
.iddetail("")
.number_destination("")
.destination(this.docid)
.status("ProcessRegisterBootcoin")
.build();
	
}

public Bootcoin changeValuePermission_sellerToTrue()
{
	this.permission_seller = true;
	return this;
}

}
