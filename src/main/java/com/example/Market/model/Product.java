package com.example.Market.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Product {
	
	@Id
	@Column(length=20)
	private Integer productid;
	
    @Column(length=20)
	private String name;
    
    @Column(length=20)
	private int price;
    
    @Column(length=20)
	private String category;
	
	
	
	public Product(Integer productid, String name, int price, String category) {
		super();
		this.productid = productid;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	
	
	public Product() {
		super();
	}



	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", price=" + price + ", category=" + category
				+ "]";
	}
	

}
