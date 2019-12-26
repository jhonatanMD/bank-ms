package com.bank.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ms.model.InfoResponse;
import com.bank.ms.webclient.CallWebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class BankController {
	
	@Qualifier("webClient")
	@Autowired
	CallWebClient webclient;
	
	@GetMapping("/getDeudas/{numDoc}")
	public Mono<InfoResponse> getDeudas(@PathVariable("numDoc") String numDoc){
		return webclient.Response(numDoc);
	}

}
