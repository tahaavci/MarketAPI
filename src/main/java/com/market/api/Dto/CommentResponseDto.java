package com.market.api.Dto;

import java.time.LocalDateTime;

public record CommentResponseDto(String commentId, String commentContent, LocalDateTime commentDate,
								 String customerId) {


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommentResponseDto that = (CommentResponseDto) o;
		return commentId.equals(that.commentId) && commentContent.equals(that.commentContent) && commentDate.equals(that.commentDate) && customerId.equals(that.customerId);
	}


}
