package com.angieverse.bookie.controllers;

import com.angieverse.bookie.entities.User;
import com.angieverse.bookie.entities.UserResponse;
import com.angieverse.bookie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception{

        if(service.verifyCredentials(user)){
            return ResponseEntity.ok(new UserResponse(user));
        }else{
            throw new Exception("Invalid user.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception{
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

}
