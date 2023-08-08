package com.virtusa.finalproject.service;

import java.util.List;

import com.virtusa.finalproject.entity.ProductModel;



public interface ProductService {
	
	public void addProduct(ProductModel p);
	public void updateProduct(ProductModel p);
	public List<ProductModel> listProducts();
	public ProductModel  getProductById(int id);
	public void removeProduct(int id);
}
