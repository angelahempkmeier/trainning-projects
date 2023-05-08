package br.com.angie.theangietalks.controller;

import br.com.angie.theangietalks.repository.UserInterface;
import br.com.angie.theangietalks.model.User;
import br.com.angie.theangietalks.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<User> postUser(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(userService.post(user));
    }

    @PutMapping
    public ResponseEntity<User> putUser(@Valid @RequestBody User user){
        return ResponseEntity.status(200).body(userService.put(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody User user){
        Boolean isValidPassword = userService.login(user);
        if(!isValidPassword){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException e){
        Map<String, String> err = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            err.put(fieldName, errorMessage);
        });
        return err;
    }
}
