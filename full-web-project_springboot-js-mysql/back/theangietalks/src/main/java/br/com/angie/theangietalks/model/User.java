package br.com.angie.theangietalks.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(min = 3, message = "Minimum of 3 characters in the name!")
    @NotBlank(message = "Name is mandatory!")
    @Column(name = "fullname", length = 200, nullable = false)
    private String fullname;

    @NotBlank(message = "Username is mandatory!")
    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Email(message = "Is necessary to put a valid email!")
    @NotBlank(message = "Email is mandatory!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "Password is mandatory!")
    @Column(name = "password_user", columnDefinition = "TEXT", nullable = false)
    private String password_user;

    @NotBlank(message = "Phone is mandatory!")
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setPassword(String password_user) {
        this.password_user = password_user;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
