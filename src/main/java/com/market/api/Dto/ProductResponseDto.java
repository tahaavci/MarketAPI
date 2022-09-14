package com.market.api.Dto;

import java.time.LocalDateTime;

public record ProductResponseDto(String productId, String productName, double productPrice,
								 LocalDateTime productExpdate) {


}
