package com.virtusa.finalproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loginId;
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	public Login() {
		
	}

	public Login(long loginId, @NotEmpty String email, @NotEmpty String password) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.password = password;
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", email=" + email + ", password=" + password + "]";
	}

	
	
}
