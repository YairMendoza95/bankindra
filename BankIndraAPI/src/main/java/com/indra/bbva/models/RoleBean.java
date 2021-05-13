package com.indra.bbva.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RoleBean {
	@Id
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "ROLE")
	private String role;

	@OneToOne
	@JoinColumn(name = "USERNAME")
	private UserBean user;

	public RoleBean() {
	}

	public RoleBean(String username, String role) {
		this.username = username;
		this.role = role;
	}

	public RoleBean(String username, String role, UserBean user) {
		this.username = username;
		this.role = role;
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RoleBean [username=" + username + ", role=" + role + "]";
	}
}
