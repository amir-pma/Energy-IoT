package com.bankino.AlertService.controller;

import com.bankino.AlertService.service.AlertService;
import com.bankino.AlertService.model.Alert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@Api(description = "REST API for handling alert mails.")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Sends alert mail.")
    public void sendMail(@RequestBody Alert alert, BindingResult bindingResult) {
        alertService.sendMail(alert, bindingResult);
    }
}
