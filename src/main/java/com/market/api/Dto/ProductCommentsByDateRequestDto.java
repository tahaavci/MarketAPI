package com.market.api.Dto;

import javax.validation.constraints.NotNull;

public record ProductCommentsByDateRequestDto(@NotNull(message = "Product ID needed.") String productId,
											  @NotNull(message = "Start date required.") String startDate,
											  @NotNull(message = "End date required.") String endDate) {

	public ProductCommentsByDateRequestDto(String productId, String startDate, String endDate) {
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductCommentsByDateRequestDto that = (ProductCommentsByDateRequestDto) o;
		return productId.equals(that.productId) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
	}

	@Override
	public String productId() {
		return productId;
	}

	@Override
	public String startDate() {
		return startDate;
	}

	@Override
	public String endDate() {
		return endDate;
	}
}
