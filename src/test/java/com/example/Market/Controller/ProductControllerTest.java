package com.example.Market.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
import com.example.Market.dto.ProductDto;
import com.example.Market.dto.UserDto;
import com.example.Market.dto.Verification;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.ProductService;
import com.example.Market.service.UserService;



@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
	
	@Mock
	ProductService productservice;
	
	@Mock
	UserService userservice;
	
	@InjectMocks
	ProductController productcontroller;
	
	static ProductDto productdto;
	static User user;
	static UserDto userdto;
	static Product product;
	static List<Product> products;
	static Verification credentials;
	
	
	@BeforeAll
	public static void setUp() {
		productdto = new ProductDto();
		productdto.setProductid(1);
		productdto.setName("Kellog's");
		productdto.setPrice(123);
		productdto.setCategory("food");
		
		user = new User();
		user.setUsername("Subarna");
		user.setPassword("1234");
	
		userdto = new UserDto();
		userdto.setUsername("subarna97");
		userdto.setPassword("124");
		
		product = new Product();
		product.setProductid(2);
		product.setName("Kellog's");
		product.setPrice(123);
		product.setCategory("food");
		
		products = new ArrayList<>();
		products.add(product);
		
		credentials = new Verification();
		credentials.setProductid(1);
		credentials.setCategory("food");;
	}
	
	@Test
	@DisplayName("Product Insert: Positive Scenario")
	public void productadd1() {
		//given or context
		when(productservice.insert(product)).thenReturn(product);
		
		//when or event
		ResponseEntity<?> result = productcontroller.saveProduct(product);
		
		//then or outcome
		assertEquals(product, result.getBody());
	}
	
	@Test
	@DisplayName("Product Insert: Negative Scenario")
	public void productadd2() {
		//given or context
		when(productservice.insert(product)).thenThrow(NullPointerException.class);
		
		
		//then or outcome
		assertThrows(NullPointerException.class, ()->productcontroller.saveProduct(product));
	}
	
	
	@Test
	@DisplayName("Search Product : Positive Scenerio")
	public void search() {
		//context
		when(productservice.authenticate(1, "food")).
		thenReturn(new ResponseEntity<>("Product Found", HttpStatus.OK));
		
		//when
		ResponseEntity<String> result = productcontroller.ProductSearch(credentials);
	
	   //outcome
	   assertEquals("Product Found", result.getBody());
	}
	
	@Test
	@DisplayName("Search Product : Negative Scenerio")
	public void search1() {
		//context
		when(productservice.authenticate(1, "food")).
		thenReturn(new ResponseEntity<>("Product Not Found", HttpStatus.CONFLICT));
		
		//when
		ResponseEntity<String> result = productcontroller.ProductSearch(credentials);
	
	   //outcome
	   assertEquals("Product Not Found", result.getBody());
	}
	
	
	@Test
	@DisplayName("Get All Products")
	public void getuser1() {
		//context
		
		when(productservice.getallproduct()).thenReturn(products);
		
		//event
		ResponseEntity<?> result = productcontroller.GetAllProduct();
		
		//outcome
		assertEquals(products,result.getBody());
	}
	
	
	@Test
	@DisplayName("User Login: Positive Scenario")
	public void useradd1() {
		//given or context
		when(userservice.addUser(userdto)).thenReturn(user);
		
		//when or event
		ResponseEntity<?> result = productcontroller.addUser(userdto);
		
		//then or outcome
		assertEquals("Log In Done", result.getBody());
	}
	
	@Test
	@DisplayName("User Login: Negative Scenario")
	public void useradd2() {
		
		//given or context
		when(userservice.addUser(userdto)).thenThrow(NullPointerException.class);
		
		//then or outcome
		assertThrows(NullPointerException.class, ()->productcontroller.addUser(userdto));
	}
	

}
