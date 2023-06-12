package com.theangietalks.loginauth.loginauth.repositories;

import com.theangietalks.loginauth.loginauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
