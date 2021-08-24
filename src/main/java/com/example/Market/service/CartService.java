package com.example.Market.service;


import org.springframework.stereotype.Service;

import com.example.Market.dto.AddToCartDto;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;

@Service
public interface CartService {

	public void addToCart(AddToCartDto addToCartDto, Product product, User user);	
	
	 public Cart getCartById(Integer cartid);
	
}
