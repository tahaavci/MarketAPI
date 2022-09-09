package com.market.api.Service;

import com.market.api.Exception.LocalDateTimeConvertionException;
import com.market.api.Repository.CommentRepository;
import com.market.api.Repository.CustomerRepository;
import com.market.api.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentServiceTest{

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
        productService = new ProductService(productRepository);
        commentService = new CommentService(commentRepository,productService,customerService);
    }


    @Test
    public void whenLocalDateTimeisNotInProperFormat_thenthrowLocalDateTimeConvertionException(){

        Assertions.assertDoesNotThrow(()->commentService.ValidateDate("2022-09-09T00:00:00"));

        Assertions.assertThrows(LocalDateTimeConvertionException.class,()->
                commentService.ValidateDate("2022-09-0900:00:00")
        );
    }




}
