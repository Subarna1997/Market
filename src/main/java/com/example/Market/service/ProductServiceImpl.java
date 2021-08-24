package com.example.Market.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Market.dao.ProductDao;
import com.example.Market.model.Product;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productdao;
	
	@Override
	public Product insert(Product product) {
		return productdao.save(product);
	}
	
	
	
  
	@Override
	public ResponseEntity<String> authenticate(Integer productid,String category) {
		List<Product> products = productdao.findAll();
		for(Product s1: products) {
			if(s1.getProductid().equals(productid) && s1.getCategory().equals(category)) {
				return new ResponseEntity<>("Product Found", HttpStatus.OK);
			}
		}
 	 return new ResponseEntity<>("Product Not Found", HttpStatus.CONFLICT) ;
		
	}
	
	
	 public Product getProductById(Integer productid) {
	        Optional<Product> optionalProduct = productdao.findById(productid);
	        if (!optionalProduct.isPresent())
	        {
	            return null;	
	        }
	        return optionalProduct.get();
	    }




	@Override
	public List<Product> getallproduct() {
		 List<Product> products = productdao.findAll();
	       
	        return products;
	}
	

}
