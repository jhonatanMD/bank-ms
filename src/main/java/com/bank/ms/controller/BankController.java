package com.bank.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/getDeudas")
	public Mono<InfoResponse> getDeudas(@RequestBody List<String> numDoc){
		return webclient.Response(numDoc);
	}

}
