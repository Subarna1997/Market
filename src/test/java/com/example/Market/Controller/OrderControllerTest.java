package com.example.Market.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.Market.controller.OrderController;
import com.example.Market.dto.OrderDto;
import com.example.Market.exception.OrderNotFoundException;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.CartService;
import com.example.Market.service.OrderService;
import com.example.Market.service.ProductService;
import com.example.Market.service.UserService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	
	
	@Mock
    private OrderService orderservice;

    @Mock
    private ProductService productService;
    
    @Mock
    private UserService userservice;
    
    @Mock
    private CartService cartservice;
    
    @InjectMocks
    private OrderController ordercontroller;
    
    static User user;
    static OrderDto orderdto;
    static Cart cart;
    static Product product;
    
    @BeforeAll
	public static void setUp() {
    	
    	user = new User();
		user.setUsername("Subarna");
		user.setPassword("1234");
		
		orderdto = new OrderDto();
		orderdto.setCartid(1);
		orderdto.setUserid(12);
		
		product = new Product();
		product.setCategory("food");
		product.setName("Chocos");
		product.setPrice(123);
		product.setProductid(1);
		
		cart = new Cart();
		cart.setCartid(1);
		cart.setProduct(product);
		cart.setQuantity(2);
		cart.setUser(user);
	
    }
    
    @Test
	@DisplayName("Order: Positive Scenario")
	public void orderadd1() throws OrderNotFoundException {
		//given or context
		orderservice.orderdetails(orderdto, user, cart);
		
		//when or event
		ResponseEntity<?> result = ordercontroller.addToCart(orderdto);
		
		//then or outcome
		assertEquals(HttpStatus.CREATED, result.getStatusCode());
	}
    
    
//    @Test
//   	@DisplayName("Order: Negative Scenario")
//   	public void orderadd2() {
//   		//given or context
//   		when(productservice.insert(product)).thenReturn(product);
//   		
//   		//when or event
//   		ResponseEntity<?> result = productcontroller.saveProduct(product);
//   		
//   		//then or outcome
//   		assertEquals(product, result.getBody());
//   	}

}
