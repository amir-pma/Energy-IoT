package com.bankino.MeterDataMessageProducer.controller;

import com.bankino.MeterDataMessageProducer.dto.MeterDataDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.*;


@RestController
public class MessageProducerController {

    private final MessageChannel kafkaOutput;

    public MessageProducerController(@Qualifier("output") MessageChannel kafkaOutput) {
        this.kafkaOutput = kafkaOutput;
    }

    @PostMapping("/energy_meter/data")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MeterDataDTO saveMeterData(@RequestBody MeterDataDTO meterDataDTO) {
        kafkaOutput.send(MessageBuilder.withPayload(meterDataDTO).build());
        return meterDataDTO;
    }
}

