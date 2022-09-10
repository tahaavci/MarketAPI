package com.market.api.Dto;

import java.time.LocalDateTime;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProductDto that = (ProductDto) o;
		return Double.compare(that.productPrice, productPrice) == 0 && productId.equals(that.productId) && productName.equals(that.productName) && productExpdate.equals(that.productExpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, productPrice, productExpdate);
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public LocalDateTime getProductExpdate() {
		return productExpdate;
	}
}
