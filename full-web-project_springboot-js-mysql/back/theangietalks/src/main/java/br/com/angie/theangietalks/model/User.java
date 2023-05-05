package br.com.angie.theangietalks.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fullname", length = 200, nullable = true)
    private String fullname;
    @Column(name = "username", length = 100, nullable = true)
    private String username;
    @Column(name = "email", length = 50, nullable = true)
    private String email;
    @Column(name = "password_user", columnDefinition = "TEXT", nullable = true)
    private String password_user;
    @Column(name = "phone", length = 15, nullable = true)
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
