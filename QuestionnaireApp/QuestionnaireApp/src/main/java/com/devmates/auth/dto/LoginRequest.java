package com.devmates.auth.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank(message = "{NotEmpty.username}")
	private String username;

	@NotBlank(message = "{NotEmpty.password}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
