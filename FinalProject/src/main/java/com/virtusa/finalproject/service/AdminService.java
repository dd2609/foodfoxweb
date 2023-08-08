package com.virtusa.finalproject.service;

import com.virtusa.finalproject.entity.Admin;

public interface AdminService {
	public Admin checkLoginForAdmin(String email,String password);
}
