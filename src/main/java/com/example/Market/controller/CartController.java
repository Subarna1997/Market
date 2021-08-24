package com.example.Market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Market.dto.AddToCartDto;
import com.example.Market.exception.ProductNotFoundException;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.CartService;
import com.example.Market.service.ProductService;
import com.example.Market.service.ProductServiceImpl;
import com.example.Market.service.UserService;

import javassist.NotFoundException;

@RestController
public class CartController {

	 @Autowired
	    private CartService cartService;

	    @Autowired
	    private ProductService productService;
	    
	    @Autowired
	    private UserService userservice;
	    
	    User user;
	    Product product;
	    
	    @PostMapping("api/v1/carts/add")
	    public ResponseEntity<String> addToCart(@RequestBody AddToCartDto addToCartDto) throws ProductNotFoundException {
            User user = userservice.getUserById(addToCartDto.getUserid());	
	        Product product = productService.getProductById(addToCartDto.getProductid());
	        if(user != null && product!= null) {
	        cartService.addToCart(addToCartDto, product, user);
	        return new ResponseEntity<String>("Added to cart", HttpStatus.CREATED);

	    } throw new ProductNotFoundException("Give proper Products");
	        }

}
