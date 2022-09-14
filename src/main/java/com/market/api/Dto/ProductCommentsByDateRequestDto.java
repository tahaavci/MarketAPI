package com.market.api.Dto;

import javax.validation.constraints.NotNull;

public record ProductCommentsByDateRequestDto(@NotNull(message = "Product ID needed.") String productId,
											  @NotNull(message = "Start date required.") String startDate,
											  @NotNull(message = "End date required.") String endDate) {

}
