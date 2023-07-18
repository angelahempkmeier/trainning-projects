package com.angieverse.bookie.repositories;

import com.angieverse.bookie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}