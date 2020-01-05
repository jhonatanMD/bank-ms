package com.bank.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ms.model.AtmEntity;
import com.bank.ms.service.IAtmService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class AtmController {
	
	
	@Autowired
	IAtmService service;
	
	@GetMapping("/getAtm")
	public Flux<AtmEntity> getAtm(){
		return service.findAllAtm();
	}
	
	@PostMapping("/postAtm/{typeAccount}/{numAccount}/{bank}/{type}/{cash}")
	public Mono<AtmEntity> postAtm(@PathVariable("typeAccount") String typeAccount
			,@PathVariable("numAccount") String numAccount
			,@PathVariable("bank") String bank,
			@PathVariable("type") String type
			,@PathVariable("cash") Double cash){
		return service.saveAtm(typeAccount, numAccount, type,bank, cash);
	}
	
	@PutMapping("/updAtm")
	public Mono<AtmEntity> updAtm(AtmEntity atm){
		return service.updAtm(atm);
	}

}
