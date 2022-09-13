package com.market.api.Dto;

import java.time.LocalDateTime;

public record ProductResponseDto(String productId, String productName, double productPrice,
								 LocalDateTime productExpdate) {


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductResponseDto that = (ProductResponseDto) o;
		return Double.compare(that.productPrice, productPrice) == 0 && productId.equals(that.productId) && productName.equals(that.productName) && productExpdate.equals(that.productExpdate);
	}


}
