package com.example.Market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Market.dto.OrderDto;
import com.example.Market.exception.OrderNotFoundException;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.CartService;
import com.example.Market.service.OrderService;
import com.example.Market.service.OrderServiceImpl;
import com.example.Market.service.ProductService;
import com.example.Market.service.ProductServiceImpl;
import com.example.Market.service.UserService;

@RestController
public class OrderController {
	
	
	 @Autowired
	    private OrderService orderservice;

	    @Autowired
	    private ProductService productService;
	    
	    @Autowired
	    private UserService userservice;
	    
	    @Autowired
	    private CartService cartservice;
	    
	    User user;
	    Cart cart;
	    
	    @PostMapping("api/v1/orders/add")
	    public ResponseEntity<String> addToCart(@RequestBody OrderDto orderdto) throws OrderNotFoundException {
	
	        
	        User user = userservice.getUserById(orderdto.getUserid());
	        Cart cart = cartservice.getCartById(orderdto.getCartid());
	      
	        //System.out.println("product to add"+  product.getName());
	        if (cart != null && user!=null) {
	        orderservice.orderdetails(orderdto, user,cart);
	        return new ResponseEntity<String>("Order Done", HttpStatus.CREATED);
	        }
	        throw new OrderNotFoundException("Order Is Missing");

	    }

}
