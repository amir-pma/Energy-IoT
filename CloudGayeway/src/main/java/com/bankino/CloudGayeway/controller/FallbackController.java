package com.bankino.CloudGayeway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Api(description = "REST API for handling fallback addresses of services.")
public class FallbackController {

    @RequestMapping("/meterDataMessageProducerFallback")
    @ApiOperation(value = "Fallback for message producer service.")
    public Mono<String> meterDataMessageProducerFallback() {
        return Mono.just("Meter Data Message Producer is taking too long to respond! Please try again later!");
    }

    @RequestMapping("/energyMeterFallback")
    @ApiOperation(value = "Fallback for energy meter service.")
    public Mono<String> energyMeterServiceFallback() {
        return Mono.just("Energy meter service is taking too long to respond! Please try again later!");
    }

    @RequestMapping("/tariffFallback")
    @ApiOperation(value = "Fallback for tariff service.")
    public Mono<String> tariffServiceFallback() {
        return Mono.just("Tariff service is taking too long to respond! Please try again later!");
    }
}
