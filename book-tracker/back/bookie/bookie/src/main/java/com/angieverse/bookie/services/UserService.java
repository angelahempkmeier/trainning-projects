package com.angieverse.bookie.services;

import com.angieverse.bookie.entities.User;
import com.angieverse.bookie.repositories.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "This object wasn't found on database."));
    }

    public Boolean findByUsernameAndPassword(String username, String password){
        User mainUser = new User();
        for(User user : getAllUsers()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public Boolean findByEmailAndPassword(String email, String password){
        User mainUser = new User();
        for(User user : getAllUsers()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public User findAUserByEmail(String email){
        User mainUser = new User();
        for(User user : getAllUsers()){
            if(user.getEmail().equals(email)){
                return mainUser;
            }
        }
        throw new NoSuchElementException("Email " + email+ "wasn't found on database.");
    }

    public void saveUser(User user){
        repository.save(user);
    }

    public boolean verifyCredentials(User user){
        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();
        if(findByEmailAndPassword(email, password) || findByUsernameAndPassword(username, password)){
            return true;
        }
        return false;
    }




}
