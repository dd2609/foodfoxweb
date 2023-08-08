package com.virtusa.finalproject.dao;

import java.util.List;

import com.virtusa.finalproject.entity.UserModel;

public interface UserHomedao {
	public abstract boolean saveUser(UserModel user);
	public UserModel getpsEm(String email,String password);
	public UserModel findAccount(String username );
	public UserModel get_info_email(String email);

}
