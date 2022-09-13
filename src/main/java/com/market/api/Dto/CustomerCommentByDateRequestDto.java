package com.market.api.Dto;

import javax.validation.constraints.NotNull;

public record CustomerCommentByDateRequestDto(@NotNull(message = "Customer ID needed.") String customerId,
											  @NotNull(message = "Start date required.") String startDate,
											  @NotNull(message = "End date required.") String endDate) {

	public CustomerCommentByDateRequestDto(String customerId, String startDate, String endDate) {
		this.customerId = customerId;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerCommentByDateRequestDto that = (CustomerCommentByDateRequestDto) o;
		return customerId.equals(that.customerId) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
	}

	@Override
	public String customerId() {
		return customerId;
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
