package com.example.Market.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="orders")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	
	 @OneToOne(targetEntity = User.class)
	    @JoinColumn(name = "userid")
	    private User user;
	 
	
	 @OneToOne(targetEntity = Cart.class)
	 @JoinColumn(name="cartid")
	 private Cart cart;
	 
	 
	public Order(int orderid, User user, Cart cart) {
		super();
		this.orderid = orderid;
		this.user = user;
		this.cart = cart;
	}

	
	public Order(Cart cart2, User user2) {
		// TODO Auto-generated constructor stub
		super();
	}


	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}
