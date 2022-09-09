package com.market.api.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.market.api.Exception.CustomerNotFoundException;
import com.market.api.Model.Customer;
import com.market.api.Repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	protected Customer findCustomerById(String id) {

		return customerRepository.findById(id).orElseThrow(

				() -> {
						logger.error("DateTime Validation Error!!");
						throw new CustomerNotFoundException(id);
				});


	}


}
