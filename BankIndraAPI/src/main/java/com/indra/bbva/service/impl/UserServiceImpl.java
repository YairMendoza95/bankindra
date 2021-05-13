package com.indra.bbva.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indra.bbva.models.UserBean;
import com.indra.bbva.repository.UserRepository;
import com.indra.bbva.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserBean> getAllUsers() {
		try {
			return (List<UserBean>) userRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public UserBean getUserByUsername(UserBean user) {
		try {
			return userRepository.findById(user.getUsername()).get();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean insertUSer(UserBean user) {
		try {
			if (userRepository.existsById(user.getUsername())) {
				LOGGER.warn("El usuario ya existe");
				return false;
			}

			userRepository.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateUser(UserBean user) {
		try {
			if (userRepository.findById(user.getUsername()).isPresent()) {
				userRepository.save(user);
			} else {
				LOGGER.debug("No se encontro el regirstro");
				return false;
			}
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteUser(UserBean user) {
		try {
			if (userRepository.findById(user.getUsername()).isPresent()) {
				userRepository.deleteById(user.getUsername());
			} else {
				LOGGER.debug("No se encontro el regirstro");
				return false;
			}
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
