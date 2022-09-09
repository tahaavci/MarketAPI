package com.market.api.Controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.api.Dto.ProductDto;
import com.market.api.Service.ProductService;

@RestController
@RequestMapping("v1/Product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("GetExpiredProducts")
	public ResponseEntity<List<ProductDto>> GetProductsExpired() {

		return ResponseEntity.ok(productService.GetExpiredProducts());
	}

	@GetMapping("GetNotExpiredProducts")
	public ResponseEntity<List<ProductDto>> GetProductsNotExpired() {

		return ResponseEntity.ok(productService.GetNotExpiredProducts());
	}

}
