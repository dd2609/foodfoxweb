package com.virtusa.finalproject.dao;

import java.util.List;

import com.virtusa.finalproject.entity.ProductModel;


public interface ProductDao {
	
	public void addProduct(ProductModel p);
	public void updateProduct(ProductModel p);
	public List<ProductModel> listProducts();
	public ProductModel  getProductById(int id);
	public void removeProduct(int id);
	public ProductModel findProduct(int productId);

}
