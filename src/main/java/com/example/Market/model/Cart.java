package com.example.Market.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Cart {

	 @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartid;
	 
	private int quantity;
	
	
	    @OneToOne
	    @JoinColumn(name = "userid", referencedColumnName ="userid")
	    private User user;
	 
	 @OneToOne
	    @JoinColumn(name = "productid", referencedColumnName = "productid")
	    private Product product;

	public Cart(Product product2, Integer integer, User user2) {
		super();
		this.product = product2;
		this.quantity=integer;
		this.user = user2;
	}

	
	
	
	public Cart() {
		super();
	}


	public Integer getCartid() {
		return cartid;
	}


	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	 
	 
	 

}
