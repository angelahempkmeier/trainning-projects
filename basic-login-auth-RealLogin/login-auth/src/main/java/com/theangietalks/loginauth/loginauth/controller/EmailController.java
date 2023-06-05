package com.theangietalks.loginauth.loginauth.controller;

import com.theangietalks.loginauth.loginauth.entity.EmailRequest;
import com.theangietalks.loginauth.loginauth.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmailRequest(@RequestBody EmailRequest emailRequest) {
        String recipient = emailRequest.getRecipient();
        String subject = "Assunto do e-mail";
        String body = "Corpo do e-mail";

        emailService.sendEmail(recipient, subject, body);
    }
}
