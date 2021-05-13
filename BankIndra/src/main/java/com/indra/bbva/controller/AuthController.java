package com.indra.bbva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indra.bbva.models.UserBean;
import com.indra.bbva.service.UserService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public String getUsers() {
		return userService.getAllUsers().toString();
	}

	@PostMapping("/login")
	public String login(UserBean user) {
		UserBean userDB = userService.getUserByUsername(user);
		String msg = "{\"message\": \"";
		if (userDB.getPassword().equals(user).getPassword()) {

		}
	}
}
