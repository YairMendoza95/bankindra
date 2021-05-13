package com.indra.bbva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
