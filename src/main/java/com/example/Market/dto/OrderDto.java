package com.example.Market.dto;

import javax.validation.constraints.NotNull;

public class OrderDto {
	
	    private   Integer cartid;
		private   Integer userid;
		
		
	
		
		public Integer getCartid() {
			return cartid;
		}
		public void setCartid(Integer cartid) {
			this.cartid = cartid;
		}
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
		
		

}
