package com.theangietalks.loginauth.loginauth.controller;

import com.theangietalks.loginauth.loginauth.entity.EmailRequest;
import com.theangietalks.loginauth.loginauth.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

//    @PostMapping("/send-email")
//    public void sendEmailRequest(@RequestBody EmailRequest emailRequest) {
//        String recipient = emailRequest.getRecipient();
//        String subject = "Assunto do e-mail";
//        String body = "Corpo do e-mail";
//
//        emailService.sendEmail(recipient, subject, body);
//    }

    @PostMapping("/send-email")
    public ResponseEntity<?> sendTokenEmail(@RequestBody EmailRequest emailRequest) throws Exception {
        String recipient = emailRequest.getRecipient();

        //preciso do token aqui
        emailService.sendEmail(recipient, "Token de autenticação", "Token: ");

        return ResponseEntity.ok("Token enviado com sucesso para o e-mail: " + recipient);
    }
}
