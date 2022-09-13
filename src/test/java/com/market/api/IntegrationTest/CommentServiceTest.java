package com.market.api.IntegrationTest;

import com.market.api.Dto.CommentResponseDto;
import com.market.api.Dto.CustomerCommentByDateRequestDto;
import com.market.api.Dto.ProductCommentsByDateRequestDto;
import com.market.api.Model.Comment;
import com.market.api.Model.Customer;
import com.market.api.Model.Product;
import com.market.api.Repository.CommentRepository;
import com.market.api.Repository.CustomerRepository;
import com.market.api.Repository.ProductRepository;
import com.market.api.Service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class CommentServiceTest extends IntegrationTestSeeding{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;



    @Test
    void testGetCommentsByProductId_DoesResponseTrue() {

        Product product = productRepository.save(GenerateProduct());
        Customer customer = customerRepository.save(GenerateCustomer());
        Comment saved = commentRepository.save(GenerateComment(product,customer));


        List<CommentResponseDto> response = commentService.GetCommentsByProductId(saved.getProduct().getProductId());


        assertEquals(customer.getCustomerId(),response.get(0).customerId());
    }


    @Test
    void testGetProductCommentsByDate_DoesReturnedDatesTrue() {
        Product product = productRepository.save(GenerateProduct());
        Customer customer = customerRepository.save(GenerateCustomer());
        commentRepository.save(GenerateComment(product,customer));

        String startDate = "2000-01-01T00:00:00";
        String endDate = "2050-01-01T00:00:00";
        ProductCommentsByDateRequestDto request = new ProductCommentsByDateRequestDto(product.getProductId(),startDate,endDate);


        List<CommentResponseDto> response = commentService.GetProductCommentsByDate(request);


        assertTrue(response.get(0).commentDate().isAfter(LocalDateTime.parse(startDate)));
        assertTrue(response.get(0).commentDate().isBefore(LocalDateTime.parse(endDate)));
    }

    @Test
    void testGetCommentsByCustomer_DoesResponseCustomerCorrect() {

        Product product = productRepository.save(GenerateProduct());
        Customer customer = customerRepository.save(GenerateCustomer());
        commentRepository.save(GenerateComment(product,customer));

        List<CommentResponseDto> response = commentService.GetCommentsByCustomer(customer.getCustomerId());

        assertEquals(customer.getCustomerId(),response.get(0).customerId());

    }

    @Test
    void testGetCustomerCommentsByDateRange_DoesReturnedDatesTrue() {

        Product product = productRepository.save(GenerateProduct());
        Customer customer = customerRepository.save(GenerateCustomer());
        commentRepository.save(GenerateComment(product,customer));

        String startDate = "2000-01-01T00:00:00";
        String endDate = "2050-01-01T00:00:00";
        CustomerCommentByDateRequestDto request = new CustomerCommentByDateRequestDto(customer.getCustomerId(),startDate,endDate);


        List<CommentResponseDto> response = commentService.GetCustomerCommentsByDateRange(request);


        assertTrue(response.get(0).commentDate().isAfter(LocalDateTime.parse(startDate)));
        assertTrue(response.get(0).commentDate().isBefore(LocalDateTime.parse(endDate)));



    }

}