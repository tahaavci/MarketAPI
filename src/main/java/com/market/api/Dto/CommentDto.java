package com.market.api.Dto;

import java.time.LocalDateTime;
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

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}
