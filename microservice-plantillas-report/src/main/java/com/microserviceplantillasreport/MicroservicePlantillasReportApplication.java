package com.microserviceplantillasreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePlantillasReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePlantillasReportApplication.class, args);
	}

}
