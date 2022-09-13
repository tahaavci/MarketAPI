package com.market.api.IntegrationTest;

import com.market.api.Dto.ProductResponseDto;
import com.market.api.Model.Product;
import com.market.api.Repository.ProductRepository;
import com.market.api.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest
class ProductServiceTest extends IntegrationTestSeeding{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private Clock clock;


    @Test
    public void testGetProductsExpired_retrievedDataIsBeforeNow(){

        Product saved = productRepository.save(GenerateExpiredProduct());

        List<ProductResponseDto> response = productService.GetExpiredProducts();

        ProductResponseDto responseDto =response.stream().filter(p -> p.productId().equals(saved.getProductId())).findAny().orElse(null);


        assertTrue(responseDto.productExpdate().isBefore(LocalDateTime.now(clock)));

    }



    @Test
    public void testGetNotExpiredProducts_retrievedDataIsAfterNow(){

        Product saved = productRepository.save(GenerateNotExpiredProduct());

        List<ProductResponseDto> response = productService.GetNotExpiredProducts();

        ProductResponseDto responseDto =response.stream().filter(p -> p.productId().equals(saved.getProductId())).findAny().orElse(null);


        assertTrue(responseDto.productExpdate().isAfter(LocalDateTime.now(clock)));

    }








}