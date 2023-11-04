package com.microservices.authuserrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthUserRolApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthUserRolApplication.class, args);
	}

}
