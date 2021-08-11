package com.bankino.TariffRequestProducer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.stream.messaging.Source;


@RestController
public class TariffRequestProducerController {

    private final Source source;

    private final String prefix;

    public TariffRequestProducerController(Source source, @Value("${http.prefix:''}") String prefix) {
        this.source = source;
        this.prefix = prefix;
    }

    @RequestMapping("/send-message")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@RequestBody String message) {
        source.output().
            send(MessageBuilder.
                withPayload(String.join("|", prefix, message)).
                build()
            );
    }
}
