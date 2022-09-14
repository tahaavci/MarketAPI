package com.market.api.Dto;

import java.time.LocalDateTime;

public record CommentResponseDto(String commentId, String commentContent, LocalDateTime commentDate,
								 String customerId) {

}
