package com.bankino.AlertService.service;

import com.bankino.AlertService.config.EmailConfig;
import com.bankino.AlertService.model.Alert;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.ValidationException;

@Service
public class AlertService {

    private final EmailConfig emailConfig;

    private static String FROM_EMAIL = "energy_iot_service@gmail.com";

    public AlertService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    public void sendMail(Alert alert, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new ValidationException("Alert email is wrong or empty");
        }

        JavaMailSenderImpl mailSender = makeMailSender();

        SimpleMailMessage mailMessage = makeMail(alert);

        mailSender.send(mailMessage);

    }

    private SimpleMailMessage makeMail(Alert alert) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(FROM_EMAIL);
        mailMessage.setTo(alert.getToEmail());
        mailMessage.setSubject(alert.getMailSubject());
        mailMessage.setText(alert.getMailText());
        return mailMessage;
    }

    private JavaMailSenderImpl makeMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());
        return mailSender;
    }
}
