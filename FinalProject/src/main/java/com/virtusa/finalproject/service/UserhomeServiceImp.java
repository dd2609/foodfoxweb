package com.virtusa.finalproject.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.finalproject.dao.UserHomedao;
import com.virtusa.finalproject.dao.UserHomedaoImp;
import com.virtusa.finalproject.entity.UserModel;
@Service
@Transactional
public class UserhomeServiceImp implements UserhomeService {
	private static Logger log = Logger.getLogger(UserhomeServiceImp.class);
	
	@Autowired
	private UserHomedao userhomedao;

	@Override
	public UserModel validateLoginModel(String email, String password) {
		 UserModel user = this.userhomedao.getpsEm(email, password);
			return user;
	}

	@Override
	public boolean registerUser(UserModel user) {
		boolean isRegister=false;
		boolean user1 = this.userhomedao.saveUser(user);
		if(user1)
			isRegister=true;
		return isRegister;
	}

	@Override
	public UserModel findAccount(String username ) {
		return userhomedao.findAccount(username);
	}
	
	@Override
	public UserModel get_info_email(String email ) {
		return userhomedao.get_info_email(email);
	}
}
