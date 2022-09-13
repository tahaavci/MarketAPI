package com.market.api.UnitTest;

import com.market.api.Dto.CommentResponseDto;
import com.market.api.Dto.TypeConvertion;
import com.market.api.Model.Comment;
import com.market.api.Model.Customer;
import com.market.api.Model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UnitTestSeeding {


    private final LocalDateTime time = LocalDateTime.parse("2022-09-01T00:00:00");

    public Customer generateCustomer(){

        return new Customer("Taha","Avcı","info@taha.com","05551");
    }


    public Product generateProduct(){

       return new Product("urun",10.5,time);
    }



    public List<Comment> generateCommentList(){

        List<Comment> comments = new ArrayList<>();

        Comment comment1 = new Comment("Good product",time,generateProduct(),generateCustomer());
        Comment comment2 = new Comment("Bad product",time,generateProduct(),generateCustomer());

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    public List<Product> generateProductList(){

        List<Product> products = new ArrayList<>();

        for (int i=0; i<10;i++)
            products.add(new Product("Product"+i,50.5+(i*5),LocalDateTime.parse("2022-09-09T00:00:00")));

        return products;
    }

    public List<CommentResponseDto> generateCommentDtoList(){

        return TypeConvertion.ConvertToCommentDto(generateCommentList());
    }





}
