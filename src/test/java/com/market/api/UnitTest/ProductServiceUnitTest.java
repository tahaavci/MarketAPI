package com.market.api.UnitTest;

import com.market.api.Dto.ProductResponseDto;
import com.market.api.Dto.TypeConvertion;
import com.market.api.Repository.ProductRepository;
import com.market.api.Service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceUnitTest extends UnitTestSeeding {

    private ProductRepository productRepository;
    private ProductService productService;
    private Clock clock;

    @BeforeEach
    void setUp(){


        clock = mock(Clock.class);
        clock = Clock.systemDefaultZone();

        productRepository = mock(ProductRepository.class);
        productService = new ProductService(productRepository, clock);

    }



    @Test
    void testgetExpiredProducts_doesRetrivedDataDtoIsTrue() {

        final String fixedDate = "2022-12-30T00:00:00.00Z";
        clock = Clock.fixed(Instant.parse(fixedDate),ZoneId.of("UTC"));
        productService = new ProductService(productRepository, clock);


        when(productRepository.findAllByproductExpdateBefore(LocalDateTime.now(clock))).thenReturn(generateProductList());


        List<ProductResponseDto> expected = TypeConvertion.ConvertToProductDto(generateProductList());
        List<ProductResponseDto> response = productService.GetExpiredProducts();


        assertEquals(expected,response);

    }

}