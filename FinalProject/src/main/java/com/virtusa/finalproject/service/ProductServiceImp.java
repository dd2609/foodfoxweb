package com.virtusa.finalproject.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.finalproject.dao.ProductDao;
import com.virtusa.finalproject.dao.ProductDaoImp;
import com.virtusa.finalproject.entity.ProductModel;
@Service
@Transactional
public class ProductServiceImp implements ProductService {
	
	private static Logger log = Logger.getLogger(ProductServiceImp.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public void addProduct(ProductModel p) {
		this.productDao.addProduct(p);
	}

	@Override
	public void updateProduct(ProductModel p) {
		this.productDao.updateProduct(p);
	}

	@Override
	public List<ProductModel> listProducts() {
		return this.productDao.listProducts();
	}

	@Override
	public ProductModel getProductById(int id) {
		return this.productDao.getProductById(id);
	}

	@Override
	public void removeProduct(int id) {
		this.productDao.removeProduct(id);

	}


	
}
