package com.indra.bbva.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.bbva.models.RoleBean;
import com.indra.bbva.repository.RoleRepository;
import com.indra.bbva.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RoleServiceImpl.class);
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<RoleBean> getAllRoles() {
		try {
			return (List<RoleBean>) roleRepository.findAll();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public RoleBean findRoleByid(RoleBean role) throws NoSuchElementException {
		try {
			return roleRepository.findById(role.getUsername()).get();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean insertRole(RoleBean role) {
		try {
			roleRepository.save(role);
			return true;
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateRole(RoleBean role) {
		try {
			if (roleRepository.findById(role.getUsername()).isPresent()) {
				roleRepository.save(role);
				return true;
			} else {
				LOGGER.warn("No se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteRole(RoleBean role) {
		try {
			if (roleRepository.findById(role.getUsername()).isPresent()) {
				roleRepository.delete(role);
				return true;
			} else {
				LOGGER.warn("No se encontro el registro");
				return false;
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return false;
		}
	}

}
