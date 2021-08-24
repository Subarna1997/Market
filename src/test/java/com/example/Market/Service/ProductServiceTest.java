package com.example.Market.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Market.controller.ProductController;
import com.example.Market.dao.ProductDao;
import com.example.Market.dto.ProductDto;
import com.example.Market.dto.Verification;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	ProductDao productdao;
	
	
	@InjectMocks
	ProductServiceImpl productserviceimpl;
	
	static ProductDto productdto;
	static Product product;
	static List<Product> products;
	static Optional<Product> options;

	
	
	@BeforeAll
	public static void setUp() {
		productdto = new ProductDto();
		productdto.setProductid(1);
		productdto.setName("Kellog's");
		productdto.setPrice(123);
		productdto.setCategory("food");
		
		product = new Product();
		product.setProductid(2);
		product.setName("Kellog's");
		product.setPrice(123);
		product.setCategory("food");
		
		products = new ArrayList<>();
		products.add(product);
		
		options = Optional.of(product);	
	
	}
	
	
	@Test
	@DisplayName("save Product details")
	public void saveproductdetails() {
		//context
		when(productdao.save(any(Product.class))).thenAnswer(i -> {
			Product product = i.getArgument(0);
			product.setProductid(1);
			return product;
		});
	
       //event
	 Product result = productserviceimpl.insert(product);
	 
	//outcome
			assert (result) != null;
		
	}
	
	@Test
	@DisplayName("Searching : positive scenario")
	public void authentication() {
		when(productdao.findAll())
		.thenReturn(products);
	
	
	ResponseEntity<String> result = productserviceimpl.authenticate(1, "food");
	
	 assertEquals(HttpStatus.CONFLICT, result.getStatusCode());

}
	
	@Test
	@DisplayName("Searching : negative scenario")
	public void authenticationTest1() {
		//context
		//when(productdao.findByProductidAndCategory(1, "food"));
		
		ResponseEntity<String> result = productserviceimpl.authenticate(1,"food");
		//event and outcome
		assertEquals("Product Not Found", result.getBody());
		
	}
	
	@Test
	@DisplayName("Get Product By Id")
	public void getuser() {
		//context
		when(productdao.findById(1)).thenReturn(options);
		
		//event
		Product s1= productserviceimpl.getProductById(1);
		
		//outcome
		assertEquals(s1,productdao.findById(1).get());
	}
	
	@Test
	@DisplayName("Get All Products")
	public void getalluser() {
		//context
		when(productdao.findAll()).thenReturn(products);
		
		//event
		List<Product> product1 = productserviceimpl.getallproduct();
		
		//outcome
		assertEquals(products,product1);
	}

}
