package com.bank.ms.service;

import com.bank.ms.model.BankEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBankService {

	Flux<BankEntity> findAllBank();
	Mono<BankEntity> saveBank(BankEntity bank);
	Mono<BankEntity> upd(BankEntity bank);
}
