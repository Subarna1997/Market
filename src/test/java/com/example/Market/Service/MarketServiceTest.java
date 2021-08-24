package com.example.Market.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.example.Market.dao.CartDao;
import com.example.Market.dao.OrderDao;
import com.example.Market.dao.UserDao;
import com.example.Market.dto.AddToCartDto;
import com.example.Market.dto.OrderDto;
import com.example.Market.dto.ProductDto;
import com.example.Market.dto.UserDto;
import com.example.Market.dto.Verification;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;
import com.example.Market.service.CartServiceImpl;
import com.example.Market.service.OrderServiceImpl;
import com.example.Market.service.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class MarketServiceTest {
	
	@Mock
	UserDao userdao;
	
	@Mock
	OrderDao orderdao;
	
	@Mock
	CartDao cartdao;
	
	
	@InjectMocks
	UserServiceImpl userserviceimpl;
	
	@InjectMocks
	OrderServiceImpl orderserviceimpl;
	
	@InjectMocks
	CartServiceImpl cartserviceimpl;
	
	
	static User user;
	static Product product;
    static Cart cart;
    static AddToCartDto addtocart; 
	static UserDto userdto;
	
	static Optional<User> options;
	static Optional<Cart> options1;
	
	@BeforeAll
	public static void setup() {
		
		
		user = new User();
		user.setUsername("Subarna");
		user.setPassword("1234");
	
		product = new Product();
		product.setProductid(2);
		product.setName("Kellog's");
		product.setPrice(123);
		product.setCategory("food");
		
		
		cart = new Cart();
		cart.setCartid(1);
		cart.setProduct(product);
		cart.setQuantity(3);
		cart.setUser(user);
		
		userdto=new UserDto();
		userdto.setUsername("subarna");
		userdto.setPassword("1234");
		
		
		addtocart = new AddToCartDto();
		addtocart.setProductid(1);
		addtocart.setQuantity(23);
		addtocart.setUserid(2);
		
		options = Optional.of(user);
		options1 = Optional.of(cart);
		
	}
	
	
	@Test
	@DisplayName("save user details")
	public void saveuserdetails() {
		//context
		when(userdao.save(any(User.class))).thenAnswer(i -> {
			User user = i.getArgument(0);
			user.setUsername("Subarna");
			return user;
		});
	
       //event
	 User result = userserviceimpl.addUser(userdto);
	 
	//outcome
			assert (result) != null;
		
	}
	
	
	@Test
	@DisplayName("Get User By Id")
	public void getuser() {
		//context
		when(userdao.findById(1)).thenReturn(options);
		
		//event
		User s1= userserviceimpl.getUserById(1);
		
		//outcome
		assertEquals(s1,userdao.findById(1).get());
	}
	
	

	@Test
	@DisplayName("Get Cart  By Id")
	public void getcart() {
		//context
		when(cartdao.findById(1)).thenReturn(options1);
		
		//event
		Cart s1= cartserviceimpl.getCartById(1);
		
		//outcome
		assertEquals(s1,cartdao.findById(1).get());
	}
	
	
	@Test
	@DisplayName("Add To Cart")
	public void addtocart() {
		
		//context
		//when(cartdao.save(cart)).thenReturn(cart);
		
		//event
		 cartserviceimpl.addToCart(addtocart, product, user);
		  
		//outcome
		  assertNotNull(addtocart.getProductid());
		  assertNotNull(cartserviceimpl);
	}
	

	@Test
	@DisplayName("Order Details")
	public void order() {
		
		//context
		//when(cartdao.save(cart)).thenReturn(cart);
		
		//event
		  cartserviceimpl.addToCart(addtocart, product, user);
		  
		//outcome
		  assertNotNull(cartserviceimpl);
		  assertNotNull(addtocart.getUserid());
	}
//	
	
	

}
