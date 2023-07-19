package com.angieverse.bookie.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserResponse {
    private String username;
    private String email;
    private String password;
    private String fullname;

    public UserResponse(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.fullname = user.getFullname();
    }


}
