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
public class RequestBootcoin implements Serializable {

private static final long serialVersionUID = -5543741594439101257L;
private Bootcoin bootcoin;

public Bootcoin toBootcoin() {
	return Bootcoin.builder()
			.docid(this.bootcoin.getDocid())
			.movil(this.bootcoin.getMovil())
			.cash_bootcoin(this.bootcoin.getCash_bootcoin())
			.email(this.bootcoin.getEmail())
			.permission_seller(this.bootcoin.isPermission_seller())
			.build();
}

}
