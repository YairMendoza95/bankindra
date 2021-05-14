package com.indra.bbva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.indra.bbva.service.UserService;

@SpringBootApplication
public class BankIndraApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BankIndraApiApplication.class, args);
	}

	@Autowired
	UserService user;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// user.getAllUsers().forEach(System.out::println);
	}

}
