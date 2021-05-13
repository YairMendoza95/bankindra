package com.indra.bbva.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.indra.bbva.models.RoleBean;

public interface RoleService {
	List<RoleBean> getAllRoles();

	RoleBean findRoleByid(RoleBean role) throws NoSuchElementException;

	boolean insertRole(RoleBean role);

	boolean updateRole(RoleBean role);

	boolean deleteRole(RoleBean role);
}
