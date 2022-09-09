package com.market.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.api.Dto.CommentDto;
import com.market.api.Dto.CustomerCommentByDateDto;
import com.market.api.Dto.ProductCommentsByDateDto;
import com.market.api.Service.CommentService;

@RestController
@RequestMapping("v1/Comment")
public class CommentController {

	private final CommentService commentService;
	public CommentController(CommentService commentService) {

		this.commentService = commentService;

	}

	@GetMapping("/GetProductComments/{productId}")
	public ResponseEntity<List<CommentDto>> GetProductComments(@PathVariable String productId) {

		if (productId == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(commentService.GetCommentsByProductId(productId));
	}

	@PostMapping("/GetProductCommentsByDateRange")
	public ResponseEntity<List<CommentDto>> GetProductCommentsByDate(@RequestBody ProductCommentsByDateDto dto) {

		if (dto == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		List<CommentDto> comments = commentService.GetProductCommentsByDate(dto);

		return ResponseEntity.ok(comments);
	}

	@GetMapping("/GetCustomerComments/{customerId}")
	public ResponseEntity<List<CommentDto>> GetCustomerComments(@PathVariable String customerId) {

		if (customerId == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(commentService.GetCommentsByCustomer(customerId));
	}

	@PostMapping("/GetCustomerCommentsByDateRange")
	public ResponseEntity<List<CommentDto>> GetCustomerCommentByDateRange(
			@Valid @RequestBody CustomerCommentByDateDto dto) {

		if (dto == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(commentService.GetCustomerCommentsByDateRange(dto));
	}

}
