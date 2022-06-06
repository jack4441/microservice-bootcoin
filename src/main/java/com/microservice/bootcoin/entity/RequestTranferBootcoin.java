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
public class RequestTranferBootcoin implements Serializable {

private static final long serialVersionUID = -1833515852640984455L;
private TransferBootcoin transferBootcoin;

public TransferBootcoin toTransferBootcoin()
{
	return TransferBootcoin.builder()
			.id_request(this.transferBootcoin.getId_request())
			.amount(this.transferBootcoin.getAmount())
			.payment_method(this.transferBootcoin.getPayment_method())
			.account_or_yanqui(this.transferBootcoin.getAccount_or_yanqui())
			.account_seller(this.transferBootcoin.getAccount_seller())
			.mobile_buyer(this.transferBootcoin.getMobile_buyer())
			.number_seller(this.transferBootcoin.getNumber_seller())
			.permission_seller(this.transferBootcoin.isPermission_seller())
			.date(this.transferBootcoin.getDate())
			.time(this.transferBootcoin.getTime())
			.build();
}

}
