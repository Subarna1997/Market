package com.example.Market.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.Market.controller.CartController;
import com.example.Market.dto.AddToCartDto;
import com.example.Market.exception.ProductNotFoundException;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.CartService;
import com.example.Market.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartControllerTest {
	
	@Mock
	CartService cartservice;
	
	@Mock
	ProductServiceImpl productservice;
	
	@InjectMocks
	CartController cartcontroller;
	
	AddToCartDto addtocartdto;
	Product product;
	User user;
	
//	@Test
//	@DisplayName("Cart Details")
//	public void getuser1() throws ProductNotFoundException {
//		//context
//		
//		Product product = productservice.getProductById(1);
//		cartservice.addToCart(addtocartdto, product, user);
//		
//		//event
//		ResponseEntity<?> result = cartcontroller.addToCart(addtocartdto);
//		
//		//outcome
//		assertEquals("Added to cart",result.getBody());
//	}
//	

}
