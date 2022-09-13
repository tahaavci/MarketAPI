package com.market.api.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.market.api.Repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}




}
