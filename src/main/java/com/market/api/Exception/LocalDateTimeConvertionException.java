package com.market.api.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LocalDateTimeConvertionException extends RuntimeException {

	
	
	public LocalDateTimeConvertionException() {

		super("Date Format Error!");
	}

	
	

}
