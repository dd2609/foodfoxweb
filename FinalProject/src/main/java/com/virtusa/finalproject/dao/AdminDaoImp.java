package com.virtusa.finalproject.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.finalproject.entity.Admin;


@Repository
@Transactional
public class AdminDaoImp implements AdminDao{
	private static Logger log = Logger.getLogger(AdminDaoImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Admin> getpsEm(String email, String password) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query query=null;
		if(email !=null && password!=null) {
			query=currentSession.createQuery("from Admin where email=:emailcheck and password=:passwordcheck", Admin.class);
		    query.setParameter("emailcheck",email);
		    query.setParameter("passwordcheck", password);
		}
		List<Admin> adminExist=query.getResultList();
		return adminExist;
	}
	

}
