package com.example.Market.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Market.dao.CartDao;
import com.example.Market.dto.AddToCartDto;
import com.example.Market.model.Cart;
import com.example.Market.model.Product;
import com.example.Market.model.User;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDao cartdao;

	public void addToCart(AddToCartDto addToCartDto, Product product, User user){
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartdao.save(cart);
    }
	
	
	 public Cart getCartById(Integer cartid) {
	        Optional<Cart> optionalProduct = cartdao.findById(cartid);
	        if (!optionalProduct.isPresent())
	        {
	            return null;	
	        }
	        return optionalProduct.get();
	    }

}
