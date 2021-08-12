package com.bankino.MeterDataMessageProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(Source.class)
@EnableSwagger2
public class MeterDataMessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeterDataMessageProducerApplication.class, args);
	}

}
