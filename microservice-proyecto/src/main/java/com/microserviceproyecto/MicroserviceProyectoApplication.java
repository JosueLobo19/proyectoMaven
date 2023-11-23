package com.microserviceproyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProyectoApplication.class, args);
	}

}
