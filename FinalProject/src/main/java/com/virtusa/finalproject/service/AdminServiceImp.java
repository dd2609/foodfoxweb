package com.virtusa.finalproject.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.finalproject.dao.AdminDao;
import com.virtusa.finalproject.entity.Admin;


@Service
@Transactional
public class AdminServiceImp implements AdminService {
	private static Logger log = Logger.getLogger(AdminServiceImp.class);
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin checkLoginForAdmin(String email, String password) {
		Admin adminExist = new Admin();
		List<Admin> admin = this.adminDao.getpsEm(email, password);
		System.out.println(admin);
		if (admin.isEmpty()) {
			adminExist = null;
		} else {
			adminExist = admin.get(0);
		}
		return adminExist;
	}

}
