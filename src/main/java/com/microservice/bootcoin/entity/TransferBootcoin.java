package com.microservice.bootcoin.entity;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document("transfer_bootcoin")
@Data
@Builder
public class TransferBootcoin implements Serializable {

private static final long serialVersionUID = 3671158970820264577L;
@Id
private String id;
@Field
private String id_request;
@Field
private double amount;
@Field
private String payment_method;
@Field
private String account_or_yanqui;
@Field
private String account_seller;
@Field
private String mobile_buyer;
@Field
private String number_seller;
@Field
private boolean permission_seller;
@Field
private String date;
@Field
private String time;

public MessageTransactWallet toMessageTransactWallet()
{
	
return MessageTransactWallet.builder()
.id(UUID.randomUUID().toString())
.idTransact(UUID.randomUUID().toString())
.amount(this.amount)
.mobile_buyer(mobile_buyer)
.mobile_seller(number_seller)
.iddetail(this.account_or_yanqui)
.number_destination(number_seller)
.destination(account_seller)
.status("ProcessBootcoin")
.build();
	
}

}
