package com.market.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.api.Model.Product;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {


    List<Product> findAllByproductExpdateBefore(LocalDateTime localDateTime);


    @Query(value = "SELECT * FROM PRODUCT WHERE PRODUCT_EXPDATE IS NULL OR  PRODUCT_EXPDATE > CURRENT_TIMESTAMP()",nativeQuery = true)
    List<Product> findNotExpired();


}
