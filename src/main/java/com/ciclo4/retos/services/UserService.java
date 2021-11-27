package com.ciclo4.retos.services;

import java.util.List;
import java.util.Optional;
import com.ciclo4.retos.repository.UserRepository;
import com.ciclo4.retos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class Service to acces Crud Repository
 * 
 * @author MARIO
 *
 */

@Service
public class UserService {

	@Autowired
	private UserRepository usrRepository;

	/**
	 * Get all users table User
	 * 
	 * @return list Users
	 */
	public List<User> getAllUsers() {
		return usrRepository.getAllUsers();
	}

	/**
	 * Get Specific User
	 * 
	 * @param id
	 * @return User
	 */
	public Optional<User> getUser(int id) {
		return usrRepository.getUser(id);
	}

	/**
	 * Insert User in Table User
	 * 
	 * @param user
	 * @return
	 */
	public User register(User user) {
		if (user.getId() == null) {
			if (existEmail(user.getEmail()) == false) {
				return usrRepository.saveUser(user);
			} else {
				return user;
			}
		} else {
			return user;
		}
	}

	/**
	 * Verify if mail exist in Table User
	 * 
	 * @param email
	 * @return false or True
	 */
	public boolean existEmail(String email) {
		return usrRepository.existEmail(email);
	}

	/**
	 * Get user with Email and Password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public User authenticateUser(String email, String password) {
		Optional<User> userVerified = usrRepository.authenticateUser(email, password);

		if (userVerified.isEmpty()) {
			User userNoDefined = new User();
			userNoDefined.setEmail(email);
			userNoDefined.setPassword(password);
			userNoDefined.setName("NO DEFINIDO");
			return userNoDefined;
		} else {
			return userVerified.get();
		}
	}

}
