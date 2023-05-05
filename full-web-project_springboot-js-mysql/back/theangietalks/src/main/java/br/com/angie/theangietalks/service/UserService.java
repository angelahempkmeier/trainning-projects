package br.com.angie.theangietalks.service;

import br.com.angie.theangietalks.model.User;
import br.com.angie.theangietalks.repository.UserInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserInterface repository;

    public UserService(UserInterface repository){
        this.repository = repository;
    }

    public List<User> users(){
        List<User> list = repository.findAll();
        return list;
    }

    public User post(User user){
        User newUser = repository.save(user);
        return newUser;
    }

    public User put(User user){
        User newUser = repository.save(user);
        return newUser;
    }

    public Boolean delete(Integer id){
        repository.deleteById(id);
        return true;
    }
}
