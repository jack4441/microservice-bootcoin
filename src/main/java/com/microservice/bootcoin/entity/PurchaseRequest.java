package com.microservice.bootcoin.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document("purchase_request")
@Data
@Builder
public class PurchaseRequest implements Serializable {
	
private static final long serialVersionUID = 71231808554127925L;
@Id
private String id;
@Field
private String amount;
@Field
private String payment_method;
@Field
private String account_or_yanqui;
@Field
private String status;

/*public RequestTranferBootcoin toRequestTranferBootcoin()
{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	return RequestTranferBootcoin.builder()
			.transferBootcoin(TransferBootcoin.builder()
					.id_request(this.id)
					.amount(this.amount)
					.payment_method(this.payment_method)
					.account_or_yanqui(this.account_or_yanqui)
					.account_seller(this.account_seller)
					.number_seller(this.number_seller)
					.date(dtf.format(LocalDateTime.now()))
					.time(dtfTime.format(LocalDateTime.now()))
					.build()
					).build();
}*/

}
