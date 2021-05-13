package com.indra.bbva.service;

import java.util.List;

import com.indra.bbva.models.UserBean;

public interface UserService {
	List<UserBean> getAllUsers();

	UserBean getUserByUsername(UserBean user);

	boolean insertUser(UserBean user);

	boolean updateUser(UserBean user);

	boolean deleteUser(UserBean user);
}
