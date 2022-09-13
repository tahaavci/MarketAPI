package com.market.api.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;

import com.market.api.Dto.TypeConvertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.market.api.Dto.ProductResponseDto;
import com.market.api.Model.Product;
import com.market.api.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final Clock clock;
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);



	public ProductService(ProductRepository productRepository, Clock clock) {
		this.productRepository = productRepository;
		this.clock = clock;
	}


	public List<ProductResponseDto> GetExpiredProducts() {

		List<Product> products = productRepository.findAllByproductExpdateBefore(LocalDateTime.now(clock));


		return TypeConvertion.ConvertToProductDto(products);
	}



	public List<ProductResponseDto> GetNotExpiredProducts() {

		List<Product> products = productRepository.findNotExpired();

		return TypeConvertion.ConvertToProductDto(products);
	}




}

