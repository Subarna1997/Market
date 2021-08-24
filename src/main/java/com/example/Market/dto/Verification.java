package com.example.Market.dto;

import javax.validation.constraints.NotEmpty;

public class Verification {
	
	//@NotEmpty(message = "Id should not be empty")
	private int productid;
	//@NotEmpty(message = "Category should not be empty")
	private String category;
	
	
	
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	

}
