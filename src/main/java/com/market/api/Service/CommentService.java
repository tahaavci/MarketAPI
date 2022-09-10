package com.market.api.Service;

import java.time.LocalDateTime;
import java.util.*;

import com.market.api.Exception.CustomerNotFoundException;
import com.market.api.Exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.market.api.Repository.CommentRepository;
import com.market.api.Exception.LocalDateTimeConvertionException;
import com.market.api.Dto.*;
import com.market.api.Model.*;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	private final ProductService productService;
	private final CustomerService customerService;

	private static final Logger logger = (Logger) LoggerFactory.getLogger(CommentService.class);

	public CommentService(CommentRepository commentRepository, ProductService productService,
			CustomerService customerService) {

		this.commentRepository = commentRepository;
		this.productService = productService;
		this.customerService = customerService;
	}

	public List<CommentDto> GetCommentsByProductId(String product_id) {

		List<Comment> comments = commentRepository.findAllByProductProductId(product_id);

		// if product not found, raise an error
		if(comments.size()==0)
			throw new ProductNotFoundException(product_id);


		return TypeConvertion.ConvertToCommentDto(comments);
	}


	
	public List<CommentDto> GetProductCommentsByDate(ProductCommentsByDateDto dto) {

		LocalDateTime startDate = ValidateDate(dto.getStartDate());
		LocalDateTime endDate = ValidateDate(dto.getEndDate());


		List<Comment> comments = commentRepository.findAllByCommentDateBetweenAndProductProductId(startDate,endDate,dto.getProductId());

		// if product not found, raise an error
		if(comments.size()==0)
			throw new ProductNotFoundException(dto.getProductId());

		return TypeConvertion.ConvertToCommentDto(comments);


	}

	public List<CommentDto> GetCommentsByCustomer(String customerId) {


		List<Comment> comments = commentRepository.findAllByCustomerCustomerId(customerId);

		// if customer not found, customer service raise an error
		if(comments.size()==0)
			throw new CustomerNotFoundException(customerId);


		return TypeConvertion.ConvertToCommentDto(comments);
	}

	public List<CommentDto> GetCustomerCommentsByDateRange(CustomerCommentByDateDto dto) {

		// date time format validation, if it is not in proper format, ValidateDate method raise an error.
		LocalDateTime startDate = ValidateDate(dto.getStartDate());
		LocalDateTime endDate = ValidateDate(dto.getEndDate());

		List<Comment> comments = commentRepository.findAllByCommentDateBetweenAndCustomerCustomerId(startDate,endDate,dto.getCustomerId());


		// if customer not found, customer service raise an error
		if(comments.size()==0)
			throw new CustomerNotFoundException(dto.getCustomerId());


		return TypeConvertion.ConvertToCommentDto(comments);
	}


	public LocalDateTime ValidateDate(String date) {

		try {
			return LocalDateTime.parse(date);
		} catch (Exception e) {
			logger.error("DateTime Validation Error!!");
			throw new LocalDateTimeConvertionException();
		}

	}


}
