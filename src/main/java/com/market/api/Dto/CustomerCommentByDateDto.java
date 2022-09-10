package com.market.api.Dto;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerCommentByDateDto that = (CustomerCommentByDateDto) o;
		return customerId.equals(that.customerId) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, startDate, endDate);
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
}
