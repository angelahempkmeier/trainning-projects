package br.com.angie.theangietalks.service;

import br.com.angie.theangietalks.dto.UserDTO;
import br.com.angie.theangietalks.model.User;
import br.com.angie.theangietalks.repository.UserInterface;
import br.com.angie.theangietalks.sucurity.Token;
import br.com.angie.theangietalks.sucurity.TokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserInterface repository;
    //private PasswordEncoder passwordEncoder;


    public List<User> users() {
        List<User> list = repository.findAll();
        return list;
    }

    public User post(User user) {
        /*String encoder = this.passwordEncoder.encode(user.getPassword_user());*/
        String pass = user.getPassword_user();
        /*user.setPassword(encoder);*/
        user.setPassword(pass);
        User newUser = repository.save(user);
        return newUser;
    }

    public User put(User user) {
        /*String encoder = this.passwordEncoder.encode(user.getPassword_user());*/
        String pass = user.getPassword_user();
        /*user.setPassword(encoder);*/
        user.setPassword(pass);
        User newUser = repository.save(user);
        return newUser;
    }

    public Boolean delete(Integer id) {
        repository.deleteById(id);
        return true;
    }

    public Boolean login(User user) {
        String password = repository.getReferenceById(user.getId()).getPassword_user();

        /*Boolean isValidPassword = passwordEncoder.matches(user.getPassword_user(), password);*/
        return user.getPassword_user().equals(password);
    }

//    public Token generateToken(@Valid UserDTO userDTO) {
//        User user = repository.findByFullnameOrEmail(userDTO.getFullname(), userDTO.getEmail());
//        if (user != null) {
//            Boolean valid = passwordEncoder.matches(userDTO.getPassword_user(), user.getPassword_user());
//            if(valid){
//                return new Token(TokenUtil.createToken(user));
//            }
//        }
//        return null;
//    }

    public User findByEmail(String email){
        return repository.findByEmail(email);
    }

    public void save(User user){
        repository.save(user);
    }
}