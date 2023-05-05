package br.com.angie.theangietalks.DAO;

import br.com.angie.theangietalks.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User, Integer> {
}
