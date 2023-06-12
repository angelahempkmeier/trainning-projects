package com.theangietalks.loginauth.loginauth.controllers;

import com.theangietalks.loginauth.loginauth.entities.EmailRequest;
import com.theangietalks.loginauth.loginauth.entities.User;
import com.theangietalks.loginauth.loginauth.entities.UserResponse;
import com.theangietalks.loginauth.loginauth.securities.JwtUtil;
import com.theangietalks.loginauth.loginauth.services.EmailService;
import com.theangietalks.loginauth.loginauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private String getToken;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authRequest) throws Exception {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // Verifique as credenciais do usuário (pode ser uma verificação no banco de dados, por exemplo)
        boolean credentialsValid = verifyCredentials(username, password);

        if (credentialsValid) {
            String token = jwtTokenUtil.generateToken(username);
            getToken = token;
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
    public ResponseEntity<?> sendTokenEmail(@RequestBody EmailRequest email) throws Exception {

        String to = email.getRecipient();
        //String to = email;
        try{
            emailService.sendEmail(to, "Token de autenticação", "Token: " + getToken);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Token enviado com sucesso para o e-mail: " + email);
    }

}
