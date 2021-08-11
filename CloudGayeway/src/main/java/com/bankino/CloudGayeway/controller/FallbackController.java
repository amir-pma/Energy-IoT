package com.bankino.CloudGayeway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/meterDataMessageProducerFallback")
    public Mono<String> meterDataMessageProducerFallback() {
        return Mono.just("Meter Data Message Producer is taking too long to respond! Please try again later!");
    }

    @RequestMapping("/energyMeterFallback")
    public Mono<String> energyMeterServiceFallback() {
        return Mono.just("Energy meter service is taking too long to respond! Please try again later!");
    }

    @RequestMapping("/tariffFallback")
    public Mono<String> tariffServiceFallback() {
        return Mono.just("Tariff service is taking too long to respond! Please try again later!");
    }
}
