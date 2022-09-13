package com.market.api.UnitTest;

import com.market.api.Dto.CommentResponseDto;
import com.market.api.Exception.ProductNotFoundException;
import com.market.api.Repository.CommentRepository;
import com.market.api.Repository.CustomerRepository;
import com.market.api.Repository.ProductRepository;
import com.market.api.Service.CommentService;
import com.market.api.Service.CustomerService;
import com.market.api.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;

import java.time.Clock;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentServiceUnitTest extends UnitTestSeeding {
    private CommentService commentService;
    private ProductService productService;
    private CustomerService customerService;

    private CommentRepository commentRepository;
    private ProductRepository productRepository;
    private CustomerRepository customerRepository;


    @BeforeEach
    public void setUp(){

        commentRepository = Mockito.mock(CommentRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
        customerRepository= Mockito.mock((CustomerRepository.class));

        customerService = new CustomerService(customerRepository);
        productService = new ProductService(productRepository, Clock.systemDefaultZone());
        commentService = new CommentService(commentRepository,productService,customerService);
    }




    @Test
    public void testGetCommentsByProductId_whenExistIdsend_thenReturnListCommentDto (){

        List<CommentResponseDto> dto = generateCommentDtoList();


        when(commentRepository.findAllByProductProductId("product-id")).thenReturn(generateCommentList());
        List<CommentResponseDto> response =  commentService.GetCommentsByProductId("product-id");


        assertEquals(dto,response);

        verify(commentRepository).findAllByProductProductId("product-id");

    }


    @Test
    public void testGetCommentsByProductId_whenNotExistIdsend_thenThrowError(){

        when(commentRepository.findAllByProductProductId("product-id")).thenReturn(generateCommentList());


        assertThrows(ProductNotFoundException.class, () -> commentService.GetCommentsByProductId("NotExistId"));
        verify(commentRepository).findAllByProductProductId("NotExistId");

    }


}
