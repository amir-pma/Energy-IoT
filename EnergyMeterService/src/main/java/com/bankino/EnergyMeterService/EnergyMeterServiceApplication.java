package com.bankino.EnergyMeterService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnergyMeterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyMeterServiceApplication.class, args);
	}

}
