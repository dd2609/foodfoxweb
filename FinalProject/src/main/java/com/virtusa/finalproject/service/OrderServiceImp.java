package com.virtusa.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.finalproject.dao.OrderDao;
import com.virtusa.finalproject.entity.Order;
@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Order saveOrder(int productId, int quantity, String username) {
		return orderDao.saveOrder(productId, quantity, username);
	}

	@Override
	public List<Order> getOrdersByUserName(String username) {
		return orderDao.getOrdersByUserName(username);
	}

}
