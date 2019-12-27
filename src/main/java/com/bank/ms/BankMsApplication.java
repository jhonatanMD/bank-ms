package com.bank.ms;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.ms.webclient.CallWebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BankMsApplication {


	  static TimerTask task = new TimerTask() {
		@Override
		public void run() {
			CallWebClient callWeb = new CallWebClient();
			
			System.out.println("hola");
			
			/* callWeb.getCreditPersonalByNumDoc("77112233").flatMap(p ->{
				 System.out.println(p.getStatus());
				 return Mono.just(p.getStatus());
			 }).subscribe();*/
		}
	};
	public static void main(String[] args) {
		SpringApplication.run(BankMsApplication.class, args);
		
		/*	Timer timer =new  Timer();
		timer.schedule(task,1000, 7000); 
		*/
	}

}
