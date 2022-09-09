package com.market.api.Service;

import java.time.LocalDateTime;
import java.util.*;

import com.market.api.Dto.TypeConvertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.market.api.Exception.ProductNotFoundException;
import com.market.api.Dto.ProductDto;
import com.market.api.Model.Product;
import com.market.api.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	public ProductService(ProductRepository productRepository) {

		this.productRepository = productRepository;

	}

	public List<ProductDto> GetExpiredProducts() {

		List<Product> products = productRepository.findAllByproductExpdateBefore(LocalDateTime.now());


		return TypeConvertion.ConvertToProductDto(products);
	}



	public List<ProductDto> GetNotExpiredProducts() {

		List<Product> products = productRepository.findNotExpired();

		return TypeConvertion.ConvertToProductDto(products);
	}



	protected Product findProductById(String id) {

		return productRepository.findById(id).orElseThrow(

				() -> {
						logger.error("Product Not Found!");
						throw new ProductNotFoundException(id);
				});

	}

}

