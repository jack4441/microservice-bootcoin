package com.microservice.bootcoin.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestPurchaseRequest implements Serializable {

private static final long serialVersionUID = 297738524419040248L;
private PurchaseRequest purchaseRequest;

public PurchaseRequest toPurchaseRequest()
{
	return PurchaseRequest.builder()
			.amount(this.purchaseRequest.getAmount())
			.payment_method(this.getPurchaseRequest().getPayment_method())
			.account_or_yanqui(this.purchaseRequest.getAccount_or_yanqui())
			.status(this.purchaseRequest.getStatus())
			.build();
}

}
