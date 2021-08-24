package com.example.Market.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Market.dto.UserDto;
import com.example.Market.dto.Verification;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.ProductService;
import com.example.Market.service.UserService;



@RestController
public class ProductController {

	@Autowired
	ProductService productservice;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/api/v1/products/addproduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) throws NullPointerException {
        if(product != null) {
		Product product1 = productservice.insert(product);
        return new ResponseEntity<>(product1,  HttpStatus.CREATED);
    }throw new NullPointerException("Product Not Found"); 
	}
	
	

	
	@PostMapping("/api/v1/products/search")
	public ResponseEntity<String> ProductSearch(@Valid @RequestBody Verification verifications)  {
		return productservice.authenticate( verifications.getProductid(), verifications.getCategory());
		
	}
	
	@PostMapping("/api/v1/products")
	public ResponseEntity<List<Product>> GetAllProduct() throws NullPointerException{
		List<Product> products = productservice.getallproduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	//For login purpose
	@PostMapping("/api/v1/user/adduser")
	public ResponseEntity<?> addUser(@RequestBody UserDto userdto) throws NullPointerException{
		
		User user = userservice.addUser(userdto);
		
		if(user.getUsername() != "" ) {
		return new ResponseEntity<String>("Log In Done",HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String>("Give Proper Inputs",HttpStatus.CREATED);
	}
	

}
