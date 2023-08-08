package com.virtusa.finalproject.dao;

import java.util.List;

import com.virtusa.finalproject.entity.Admin;



public interface AdminDao {
	
	public List<Admin> getpsEm(String email, String password);

}
