package com.bank.ms;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.ms.webclient.CallWebClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BankMsApplication {
	  static CallWebClient callWeb  = new CallWebClient();
	  static TimerTask task = new TimerTask() {
		@Override
		public void run() {
				
			callWeb.getCreditPersonal().flatMap(p ->{
				 if(p.getDateCredit()!= null) {
					 if(p.getDateCredit().compareTo(new Date()) < 0 || p.getDateCredit().compareTo(new Date()) == 0 
							 && p.getCash()< p.getCashPay()) {
						 p.setStatus("0");
					 }
					 return callWeb.putCreditPersonal(p).map(per ->{
						 return Mono.just(per);
				 		}); 	
				 }
				 return Mono.just(p);
			 }).subscribe();
		}
	};
	public static void main(String[] args) {
		SpringApplication.run(BankMsApplication.class, args);
		Timer timer =new  Timer();
		timer.schedule(task,1000, (60000 * 60) * 24); 
		
	}

}
