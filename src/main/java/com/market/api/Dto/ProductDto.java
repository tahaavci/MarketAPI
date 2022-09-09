package com.market.api.Dto;

import java.time.LocalDateTime;

public class ProductDto {
	
	
	private String productId;
	private String productName;
	private double productPrice;
	private LocalDateTime productExpdate;
	
	
	public ProductDto(String productId, String productName, double productPrice, LocalDateTime productExpdate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpdate = productExpdate;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public LocalDateTime getProductExpdate() {
		return productExpdate;
	}


	public void setProductExpdate(LocalDateTime productExpdate) {
		this.productExpdate = productExpdate;
	}

	

}
