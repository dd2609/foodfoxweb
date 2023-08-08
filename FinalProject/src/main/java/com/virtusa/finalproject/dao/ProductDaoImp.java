package com.virtusa.finalproject.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.virtusa.finalproject.entity.ProductModel;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao {

private static Logger log = Logger.getLogger(ProductDaoImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(ProductModel p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(p);
		log.info("Product saved successfully, Product Details="+p);

	}

	@Override
	public void updateProduct(ProductModel p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		log.info("Product updated successfully, Product Details="+p);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductModel> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProductModel> productList = session.createQuery("from ProductModel").list();
		for(ProductModel p : productList){
			log.info("Product List::"+p);
		}
		return productList;
		
	}

	@Override
	public ProductModel getProductById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ProductModel p = (ProductModel) session.load(ProductModel.class, new Integer(id));
		log.info("Product loaded successfully, Product details="+p);
		return p;
		
	}

	@Override
	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProductModel p = (ProductModel) session.load(ProductModel.class,id);
		if(null != p){
			session.delete(p);
		}
		log.info("Product deleted successfully, Product details="+p);

	}
	
	 @Override
	    public ProductModel findProduct(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        Criteria crit = session.createCriteria(ProductModel.class);
	        crit.add(Restrictions.eq("id", id));
	        return (ProductModel) crit.uniqueResult();
	        
	    }


}
