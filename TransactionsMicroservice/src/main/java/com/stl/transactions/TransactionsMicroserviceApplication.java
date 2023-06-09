package com.stl.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsMicroserviceApplication.class, args);
	}

}
