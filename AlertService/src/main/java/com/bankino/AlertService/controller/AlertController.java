package com.bankino.AlertService.controller;

import com.bankino.AlertService.service.AlertService;
import com.bankino.AlertService.model.Alert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public void saveCountry(@RequestBody Alert alert, BindingResult bindingResult) {
        alertService.sendMail(alert, bindingResult);
    }
}
