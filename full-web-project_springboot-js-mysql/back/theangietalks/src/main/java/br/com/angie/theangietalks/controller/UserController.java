package br.com.angie.theangietalks.controller;

import br.com.angie.theangietalks.DAO.UserInterface;
import br.com.angie.theangietalks.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserInterface userInterface;

    @GetMapping("/users")
    public List<User> usersList(){
        return (List<User>) userInterface.findAll();
    }

}
