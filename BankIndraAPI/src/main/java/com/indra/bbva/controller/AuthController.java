package com.indra.bbva.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AuthController.class);

	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bcrypt;

	@GetMapping("/users")
	public List<UserBean> getUsers() {
		List<UserBean> users = new ArrayList<>();
		userService.getAllUsers().forEach(users::add);
		LOGGER.debug(users.toString());
		return users;
	}

	@PostMapping("/login")
	public RsponseEntity login(@RequestBody UserBean user) {
		UserBean userDB = userService.getUserByUsername(user);
		if (!userDB.getPassword().equals(user.getPassword())) {
			return new RsponseEntity(HttpStatus.);
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
