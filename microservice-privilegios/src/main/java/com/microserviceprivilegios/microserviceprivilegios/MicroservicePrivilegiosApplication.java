package com.microserviceprivilegios.microserviceprivilegios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePrivilegiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePrivilegiosApplication.class, args);
	}

}
