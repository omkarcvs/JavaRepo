package com.example.paymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PaymentGatewayApplication  extends SpringBootServletInitializer{

	
	    @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    	return builder.sources(PaymentGatewayApplication.class);
	    }
	    
	     public static void main(String[] args) {
	 		SpringApplication.run(PaymentGatewayApplication.class, args);
	 	}	
		
}
