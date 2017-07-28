package com.bwjk.sso.model.request;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginRequestDTO {

	@NotEmpty
	public String userName;
	
	@NotEmpty
	public String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
