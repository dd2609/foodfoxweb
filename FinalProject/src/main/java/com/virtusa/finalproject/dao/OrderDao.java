package com.virtusa.finalproject.dao;


import java.util.List;

import com.virtusa.finalproject.entity.Order;


public interface OrderDao {
	public Order saveOrder(int productId,int quantity,String username);
	 
    public List<Order> getOrdersByUserName(String username);
    
    public Order findOrder(int orderId);
    
    public Order getOrderByProdID_UserId(int productId, int userId);
    
    public List<Order> updateOrder(int productId, int userId,double price, int quantity,String email);
    
    public List<Order> getAllOrders();
    
}
