package com.market.api.Dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDto {

	
	private String commentId;
	private String commentContent; 
	private LocalDateTime commentDate;
	private String userId;
	
	public CommentDto(String commentId, String commentContent, LocalDateTime commentDate, String userId) {

		this.commentId = commentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.userId = userId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommentDto that = (CommentDto) o;
		return commentId.equals(that.commentId) && commentContent.equals(that.commentContent) && commentDate.equals(that.commentDate) && userId.equals(that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentId, commentContent, commentDate, userId);
	}

	public String getCommentId() {
		return commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public String getUserId() {
		return userId;
	}
}
