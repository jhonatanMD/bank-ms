package com.bank.ms.service;

import com.bank.ms.model.EntityDebtor;

import reactor.core.publisher.Mono;

public interface IDebtorService {

	Mono<EntityDebtor> saveDebtor(EntityDebtor entityDebtor);
	
}
