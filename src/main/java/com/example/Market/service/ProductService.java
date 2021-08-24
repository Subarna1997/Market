package com.example.Market.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Market.model.Product;

@Service
public interface ProductService {
	
	public Product insert(Product product);
	
	public ResponseEntity<String> authenticate(Integer productid, String category);
	
	public Product getProductById(Integer productid);
	
	public List<Product> getallproduct();
}
