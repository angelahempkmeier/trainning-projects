package br.com.angie.theangietalks.controller;

import br.com.angie.theangietalks.repository.UserInterface;
import br.com.angie.theangietalks.model.User;
import br.com.angie.theangietalks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.status(200).body(userService.users());
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        return ResponseEntity.status(201).body(userService.post(user));
    }

    @PutMapping
    public ResponseEntity<User> putUser(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.put(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
