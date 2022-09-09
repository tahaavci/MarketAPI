package com.market.api.Dto;

public class CustomerCommentByDateDto {
	
	private String customerId;
	private String startDate;
	private String endDate;
	
	
	public CustomerCommentByDateDto(String customerId, String startDate, String endDate) {
		super();
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
