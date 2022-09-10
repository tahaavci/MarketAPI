package com.market.api.Service;

import com.market.api.Dto.CommentDto;
import com.market.api.Dto.TypeConvertion;
import com.market.api.Model.Comment;
import com.market.api.Model.Customer;
import com.market.api.Model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestSeeding {


    private final LocalDateTime time = LocalDateTime.parse("2022-09-01T00:00:00");

    public Customer generateCustomer(){

        return new Customer("Taha","Avcı","info@taha.com","05551");
    }


    public Product generateProduct(){

       return new Product("urun",10.5,time);
    }


    public List<Comment> generateComment(){

        List<Comment> comments = new ArrayList<>();

        Comment comment1 = new Comment("Good product",time,generateProduct(),generateCustomer());
        Comment comment2 = new Comment("Bad product",time,generateProduct(),generateCustomer());

        comments.add(comment1);
        comments.add(comment2);

        return comments;
    }

    public List<CommentDto> generateCommentDtoList(){

        return TypeConvertion.ConvertToCommentDto(generateComment());
    }





}
