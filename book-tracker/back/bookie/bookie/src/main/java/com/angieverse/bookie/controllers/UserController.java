package com.angieverse.bookie.controllers;

import com.angieverse.bookie.entities.User;
import com.angieverse.bookie.entities.UserResponse;
import com.angieverse.bookie.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
