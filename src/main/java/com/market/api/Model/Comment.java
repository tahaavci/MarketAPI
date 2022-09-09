package com.market.api.Model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comment {

	// 32 hex unique ID generates
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String commentId;

	@Size(max = 500)
	private String commentContent;
	private LocalDateTime commentDate;

	// A product can receive multiple comments.

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", nullable = false, referencedColumnName = "productId")
	private Product product;

	// A customer can make many comments.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false,referencedColumnName = "customerId")
	private Customer customer;

	public Comment() {

	}

	public Comment(@Size(max = 500) String commentContent, LocalDateTime commentDate, Product product,
			Customer customer) {

		this.commentId = "";
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.product = product;
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentId, commentContent, commentDate);
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

	public Product getProduct() {
		return product;
	}

	public Customer getCustomer() {
		return customer;
	}
}
