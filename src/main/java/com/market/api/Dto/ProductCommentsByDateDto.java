package com.market.api.Dto;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductCommentsByDateDto that = (ProductCommentsByDateDto) o;
		return productId.equals(that.productId) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, startDate, endDate);
	}

	public String getProductId() {
		return productId;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}
}
