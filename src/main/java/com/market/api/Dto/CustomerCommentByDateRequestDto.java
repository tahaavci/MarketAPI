package com.market.api.Dto;

import javax.validation.constraints.NotNull;

public record CustomerCommentByDateRequestDto(@NotNull(message = "Customer ID needed.") String customerId,
											  @NotNull(message = "Start date required.") String startDate,
											  @NotNull(message = "End date required.") String endDate) {

}
