package com.ciclo4.retos.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciclo4.retos.model.User;

/**
 * Define Class UserRepository an Methods CRUD to Service
 * @author MARIO
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private UserCrudRepository CrudRepositoryUser;

	/**
	 * Method to get list users table User
	 * @return
	 */
	public List<User> getAllUsers() {
		return (List<User>) CrudRepositoryUser.findAll();
	}

	/**
	 * Method to get unique user by id table User
	 * @return
	 */
	public Optional<User> getUser(int id) {
		return CrudRepositoryUser.findById(id);
	}

	/**
	 * Method to insert user on table User
	 * @param user
	 * @return
	 */
	public User saveUser(User user) {
		return CrudRepositoryUser.save(user);
	}
    
	/**
	 * Method to verify email on field email table User
	 * @param email
	 * @return
	 */
	
	public boolean existEmail(String email) {
		Optional<User> user = CrudRepositoryUser.findByEmail(email);

		return !user.isEmpty();
	}

	/**
	 * Method to get unique pair email and user table User
	 * @param email
	 * @param password
	 * @return
	 */
	public Optional<User> authenticateUser(String email, String password) {
		return CrudRepositoryUser.findByEmailAndPassword(email, password);
	}

}
