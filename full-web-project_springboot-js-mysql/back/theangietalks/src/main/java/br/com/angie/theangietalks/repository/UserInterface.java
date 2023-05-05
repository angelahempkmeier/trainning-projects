package br.com.angie.theangietalks.repository;

import br.com.angie.theangietalks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, Integer> {
}
