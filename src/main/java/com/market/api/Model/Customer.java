package com.market.api.Model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Customer {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String customerId;

	@Size(max = 50)
	private String customerName;
	@Size(max = 50)
	private String customerSurname;

	@Column(unique = true)
	@Size(max = 50)
	private String customerEmail;

	@Column(unique = true)
	@Size(max = 15)
	private String customerPhone;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	public Customer() {
		super();
	}

	public Customer(@Size(max = 50) String customerName, @Size(max = 50) String customerSurname,
			@Size(max = 50) String customerEmail, @Size(max = 15) String customerPhone) {

		this.customerId = "";
		this.customerName = customerName;
		this.customerSurname = customerSurname;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	@Override
	public int hashCode() {
		// Set uses hashcode , so I make it easy to get hashcode, no need for "Comment"
		// class
		return Objects.hash(customerEmail, customerName, customerSurname, customerPhone);
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerSurname() {
		return customerSurname;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public Set<Comment> getComments() {
		return comments;
	}
}
