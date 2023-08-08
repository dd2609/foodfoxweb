package com.virtusa.finalproject.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
@Entity
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Lob
	private String imageUrl;
	private String productName;
	private double price;
	private String description;
	@Min(value=0,message = "msg1")
	private int quantity;
	
	public ProductModel() {
		
	}

	public ProductModel(int productId, String imageUrl, String productName, double price, String description,
			int quantity) {
		super();
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", imageUrl=" + imageUrl + ", productName=" + productName
				+ ", price=" + price + ", description=" + description + ", quantity=" + quantity + "]";
	}

	

}
