package com.bank.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ms.model.BankEntity;
import com.bank.ms.service.IBankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class BankController {
	
	@Autowired
	IBankService service;
	
	@GetMapping("/getBank")
	public Flux<BankEntity> getBank(){
		return service.findAllBank();
	}
	
	@PostMapping("/postBank")
	public Mono<BankEntity> postBank(BankEntity bank){
		return service.saveBank(bank);
	}
	
	@PutMapping("/updBank")
	public Mono<BankEntity> updBank(BankEntity bank){
		return service.upd(bank);
	}
}
