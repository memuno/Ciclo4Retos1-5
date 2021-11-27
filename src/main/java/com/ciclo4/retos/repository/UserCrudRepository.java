package com.ciclo4.retos.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.ciclo4.retos.model.User;

/*
 * Define Interface Crud Repository  : Table User
 * @author: G17_Group:5 Mario Gomez
 * 
 */

public interface UserCrudRepository extends CrudRepository<User, Integer>{
	
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);

}
