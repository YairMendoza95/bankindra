package com.indra.bbva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.indra.bbva.models.UserBean;
import com.indra.bbva.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bcrypt;

	@GetMapping("/users")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public List<UserBean> getUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/login")
	public UserBean login(@RequestBody UserBean user) {
		UserBean userDB = userService.getUserByUsername(user);
		if (!userDB.getPassword().equals(user.getPassword())) {
			return null;
		}
		return userDB;
	}

	@PostMapping("/signup")
	public UserBean signup(@RequestBody UserBean user) {
		user.setPassword(bcrypt.encode(user.getPassword()));
		user.setActive(1);
		userService.insertUser(user);
		return user;
	}
}
