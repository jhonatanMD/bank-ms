package com.bank.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.ms.model.AtmEntity;

import reactor.core.publisher.Mono;

public interface IAtmRepository extends ReactiveMongoRepository<AtmEntity,String>{

	Mono<AtmEntity> findByNumAccount(String numAccount);
}
