package com.virtusa.finalproject.service;

import java.util.List;

import com.virtusa.finalproject.entity.Order;

public interface OrderService {
	public Order saveOrder(int productId,int quantity,String username);
	 
    public List<Order> getOrdersByUserName(String username);
    
}
