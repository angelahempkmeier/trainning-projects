package com.theangietalks.loginauth.loginauth.controller;

import com.theangietalks.loginauth.loginauth.entity.EmailRequest;
import com.theangietalks.loginauth.loginauth.entity.User;
import com.theangietalks.loginauth.loginauth.entity.UserResponse;
import com.theangietalks.loginauth.loginauth.security.JwtUtil;
import com.theangietalks.loginauth.loginauth.services.EmailService;
import com.theangietalks.loginauth.loginauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserService service;
    @Autowired
    private EmailService emailService;
    private String email;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // Verifique as credenciais do usuário (pode ser uma verificação no banco de dados, por exemplo)
        boolean credentialsValid = verifyCredentials(username, password);

        if (credentialsValid) {
            String token = jwtTokenUtil.generateToken(username);
            authRequest.setToken(token);
            return ResponseEntity.ok(new UserResponse(token));
        } else {
            throw new Exception("Invalid username or password");
        }
    }

    private boolean verifyCredentials(String username, String password) {
        if(service.findByUsernameAndPassword(username, password)){
            return true;
        }
        return false;
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody User authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        boolean credentialsValid = verifyCredentials(username, password);

        if (credentialsValid) {
            String token = jwtTokenUtil.generateToken(username);
            return ResponseEntity.ok(token);
        } else {
            throw new Exception("Invalid username or password");
        }
    }

    @PostMapping("/send-token-email")
    public ResponseEntity<?> sendTokenEmail(@RequestBody EmailRequest emailRequest) throws Exception {
        String recipient = emailRequest.getRecipient();

        //preciso do token aqui
        emailService.sendEmail(recipient, "Token de autenticação", "Token: ");

        return ResponseEntity.ok("Token enviado com sucesso para o e-mail: " + recipient);
    }

    @PostMapping("/send-data")
    public ResponseEntity<String> receiveData(@RequestParam("email") String email){
        this.email = email;
        return ResponseEntity.ok("Data succefully received.");
    }

}
