package com.virtusa.finalproject.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.finalproject.entity.UserModel;
@Repository
@Transactional
public class UserHomedaoImp implements UserHomedao {
	
	private static Logger log = Logger.getLogger(UserHomedaoImp.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
    private SessionFactory sessionFactory;


	@Override
	public boolean saveUser(UserModel user) {
		int id = (Integer)this.hibernateTemplate.save(user);
		if(id>0)
			return true;
	
		return false;
	}
	@SuppressWarnings("unchecked")
	@Override
	public UserModel getpsEm(String email, String password) {
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(UserModel.class);
		detachedCriteria.add(Restrictions.eq("email", email));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<UserModel> findByCriteria = (List<UserModel>)this.hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
	return null;
	}
	
	@Override
	public UserModel findAccount(String username ) {
		
		 Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(UserModel.class);
	        crit.add(Restrictions.eq("username", username));
	        return (UserModel) crit.uniqueResult();
	    }
	
	@Override
	public UserModel get_info_email(String email){
		Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(UserModel.class);
        crit.add(Restrictions.eq("email", email));
        return (UserModel) crit.uniqueResult();
	}
}

	

