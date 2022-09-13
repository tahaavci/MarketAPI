package com.market.api.IntegrationTest;

import com.market.api.Model.Comment;
import com.market.api.Model.Customer;
import com.market.api.Model.Product;

import java.time.LocalDateTime;
import java.util.Random;

public class IntegrationTestSeeding{


    public Product GenerateProduct(){
        return new Product("Integration Test Product",99.9,LocalDateTime.now());
    }

    public Customer GenerateCustomer(){
        Random rand = new Random();
        return new Customer("Taha","Avcı","test"+rand.nextInt(1,1000)+"@taha.com","02321112"+rand.nextInt(1,1000));
    }

    public Comment GenerateComment(Product product,Customer customer){

        return new Comment("Integration Test Comment",LocalDateTime.now(),product,customer);
    }


    public Product GenerateExpiredProduct(){

        return new Product("Expired Product",10.9, LocalDateTime.parse("2018-01-01T00:00:00"));

    }

    public Product GenerateNotExpiredProduct(){
            return new Product("Expired Product",10.9, LocalDateTime.parse("2050-01-01T00:00:00"));
    }




}








