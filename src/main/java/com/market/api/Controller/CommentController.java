package com.market.api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.api.Dto.CommentResponseDto;
import com.market.api.Dto.CustomerCommentByDateRequestDto;
import com.market.api.Dto.ProductCommentsByDateRequestDto;
import com.market.api.Service.CommentService;

@RestController
@RequestMapping("v1/Comment")
public class CommentController {

	private final CommentService commentService;
	public CommentController(CommentService commentService) {

		this.commentService = commentService;
	}



	@GetMapping("/GetProductComments/{productId}")
	public ResponseEntity<List<CommentResponseDto>> GetProductComments(@PathVariable String productId) {


		return ResponseEntity.ok(commentService.GetCommentsByProductId(productId));
	}



	@PostMapping("/GetProductCommentsByDateRange")
	public ResponseEntity<List<CommentResponseDto>> GetProductCommentsByDate(@Valid @RequestBody ProductCommentsByDateRequestDto dto) {

		List<CommentResponseDto> comments = commentService.GetProductCommentsByDate(dto);

		return ResponseEntity.ok(comments);
	}

	@GetMapping("/GetCustomerComments/{customerId}")
	public ResponseEntity<List<CommentResponseDto>> GetCustomerComments(@PathVariable String customerId) {


		return ResponseEntity.ok(commentService.GetCommentsByCustomer(customerId));
	}

	@PostMapping("/GetCustomerCommentsByDateRange")
	public ResponseEntity<List<CommentResponseDto>> GetCustomerCommentByDateRange(@Valid @RequestBody CustomerCommentByDateRequestDto dto) {


		return ResponseEntity.ok(commentService.GetCustomerCommentsByDateRange(dto));
	}

}
