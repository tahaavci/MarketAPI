package com.market.api.Dto;

public class ProductCommentsByDateDto {

	private String productId;
	private String startDate;
	private String endDate;
	
	
	public ProductCommentsByDateDto(String productId, String startDate, String endDate) {
		super();
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
}
