package com.market.api.Service;

import com.market.api.Dto.CommentDto;
import com.market.api.Exception.LocalDateTimeConvertionException;
import com.market.api.Exception.ProductNotFoundException;
import com.market.api.Repository.CommentRepository;
import com.market.api.Repository.CustomerRepository;
import com.market.api.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CommentServiceTest extends TestSeeding{

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
    public void testValidateDate_whenLocalDateTimeisNotInProperFormat_thenThrowLocalDateTimeConvertionException(){

        assertDoesNotThrow(()->commentService.ValidateDate("2022-09-09T00:00:00"));

        assertThrows(LocalDateTimeConvertionException.class,()->
                commentService.ValidateDate("2022-09-0900:00:00")
        );
    }

    @Test
    public void testGetCommentsByProductId_whenExistIdsend_thenReturnListCommentDto (){

        List<CommentDto> dto = generateCommentDtoList();


        when(commentRepository.findAllByProductProductId("product-id")).thenReturn(generateComment());
        List<CommentDto> response =  commentService.GetCommentsByProductId("product-id");


        assertEquals(dto,response);

        verify(commentRepository).findAllByProductProductId("product-id");

    }


    @Test
    public void testGetCommentsByProductId_whenNotExistIdsend_thenThrowError(){

        when(commentRepository.findAllByProductProductId("product-id")).thenReturn(generateComment());


        assertThrows(ProductNotFoundException.class, () -> commentService.GetCommentsByProductId("NotExistId"));
    }


}