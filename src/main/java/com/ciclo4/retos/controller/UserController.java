package com.ciclo4.retos.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.ciclo4.retos.model.User;
import com.ciclo4.retos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService ServiceUser;

	@GetMapping("/all")
	public List<User> getAll() {
		return ServiceUser.getAllUsers();
	}

	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public User registrar(@RequestBody User user) {
		return ServiceUser.register(user);
	}

	@GetMapping("/{email}/{password}")
	public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
		return ServiceUser.authenticateUser(email, password);
	}

	@GetMapping("/{email}")
	public boolean existeEmail(@PathVariable("email") String email) {
		return ServiceUser.existEmail(email);
	}

}
