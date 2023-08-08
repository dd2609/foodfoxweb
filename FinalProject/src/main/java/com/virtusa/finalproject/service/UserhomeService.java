package com.virtusa.finalproject.service;

import com.virtusa.finalproject.entity.UserModel;

public interface UserhomeService {
	public abstract UserModel validateLoginModel(String email,	String password);
	public abstract boolean registerUser(UserModel user);
	public UserModel findAccount(String username );
	public UserModel get_info_email(String email);
}
