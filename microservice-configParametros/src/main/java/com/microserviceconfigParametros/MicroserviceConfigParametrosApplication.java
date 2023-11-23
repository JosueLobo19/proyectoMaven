package com.microserviceconfigParametros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceConfigParametrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigParametrosApplication.class, args);
	}

}
