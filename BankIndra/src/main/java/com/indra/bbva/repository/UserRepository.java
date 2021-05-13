package com.indra.bbva.repository;

import org.springframework.data.repository.CrudRepository;

import com.indra.bbva.models.UserBean;

public interface UserRepository extends CrudRepository<UserBean, String> {
	UserBean findUSerByUsername(UserBean user);
}
