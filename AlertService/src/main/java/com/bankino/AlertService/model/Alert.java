package com.bankino.AlertService.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class Alert {
    @NotNull
    private String mailSubject;

    @NotNull
    @Email
    private String toEmail;

    @NotNull
    private String mailText;

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getMailText() {
        return mailText;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    public Alert() {
    }

    public Alert(String mailSubject, String toEmail, String mailText) {
        this.mailSubject = mailSubject;
        this.toEmail = toEmail;
        this.mailText = mailText;
    }
}
