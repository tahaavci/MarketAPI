package com.market.api.Model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String productId;

	private String productName;
	private double productPrice;
	private LocalDateTime productExpdate = null;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	public Product() {
	}

	public Product(String productName, double productPrice, LocalDateTime productExpdate) {
		this.productId = "";
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpdate = productExpdate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productName, productPrice, productExpdate);
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

	public Set<Comment> getComments() {
		return comments;
	}
}
