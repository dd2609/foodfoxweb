package com.virtusa.finalproject.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Orders",
uniqueConstraints = { @UniqueConstraint(columnNames = "orderNum") })
public class Order {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer o_id;
    private Date orderDate;
    private int orderNum;
    private double amount;
    private int quantity;
    @ManyToOne(targetEntity=ProductModel.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", nullable=false)
    private ProductModel product;
    @ManyToOne(targetEntity=UserModel.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private UserModel user;
    
    public Order() {
    	
    }

	public Order(Integer o_id, Date orderDate, int orderNum, double amount, int quantity, ProductModel product,
			UserModel user) {
		super();
		this.o_id = o_id;
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.amount = amount;
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}

	public Integer getO_id() {
		return o_id;
	}

	public void setO_id(Integer o_id) {
		this.o_id = o_id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [o_id=" + o_id + ", orderDate=" + orderDate + ", orderNum=" + orderNum + ", amount=" + amount
				+ ", quantity=" + quantity + ", product=" + product + ", user=" + user + "]";
	}

	
}
