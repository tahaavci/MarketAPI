package com.market.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

	
	
	public CustomerNotFoundException(String id) {

		super("Customer Not Found!  ID : " +id);
	}

}
