package com.example.Market.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Market.dao.OrderDao;
import com.example.Market.dto.OrderDto;
import com.example.Market.model.Cart;
import com.example.Market.model.Order;
import com.example.Market.model.Product;
import com.example.Market.model.User;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderdao;
	
	@Override
	public void orderdetails(OrderDto orderDto, User user, Cart cart) {
		
		Order order = new Order(cart, user);
        orderdao.save(order);
		
	}

}
