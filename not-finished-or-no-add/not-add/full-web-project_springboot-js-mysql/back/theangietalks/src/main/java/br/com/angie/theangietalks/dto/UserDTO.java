package br.com.angie.theangietalks.dto;


public class UserDTO {
    private String fullname;
    private String username;
    private String email;
    private String password_user;

    public UserDTO(String fullname, String username, String email, String password_user) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password_user = password_user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }
}
