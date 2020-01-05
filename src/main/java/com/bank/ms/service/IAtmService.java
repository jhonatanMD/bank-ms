package com.bank.ms.service;

import com.bank.ms.model.AtmEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAtmService {

	Flux<AtmEntity> findAllAtm();
	Mono<AtmEntity> saveAtm(String typeAccount,String numAccount,String type, String bank,Double cash);
	Mono<AtmEntity> updAtm(AtmEntity atm);
}
