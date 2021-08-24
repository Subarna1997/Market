package com.example.Market.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.Market.dto.OrderDto;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;


@Service
@Transactional
public interface OrderService {

	public void orderdetails(OrderDto orderDto, User user, Cart cart);	
}
