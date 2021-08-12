package com.bankino.MeterDataMessageProducer.controller;

import com.bankino.MeterDataMessageProducer.dto.MeterDataDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(description = "REST API for handling production of transaction messages.")
public class MessageProducerController {

    private final MessageChannel kafkaOutput;

    public MessageProducerController(@Qualifier("output") MessageChannel kafkaOutput) {
        this.kafkaOutput = kafkaOutput;
    }

    @PostMapping("/energy_meter/data")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Sends meter data transactions through kafka.")
    public MeterDataDTO saveMeterData(@RequestBody MeterDataDTO meterDataDTO) {
        kafkaOutput.send(MessageBuilder.withPayload(meterDataDTO).build());
        return meterDataDTO;
    }
}

