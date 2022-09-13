package com.market.api.Dto;

import com.market.api.Model.Comment;
import com.market.api.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class TypeConvertion {


    public static List<CommentResponseDto> ConvertToCommentDto(List<Comment> comments){

        List<CommentResponseDto> response = new ArrayList<>();


        for (Comment item : comments){
            CommentResponseDto dto = new CommentResponseDto(item.getCommentId(),item.getCommentContent()
                                            ,item.getCommentDate(),item.getCustomer().getCustomerId());
            response.add(dto);
        }
        return response;
    }


    public static List<ProductResponseDto> ConvertToProductDto(List<Product> products){

        List<ProductResponseDto> response = new ArrayList<>();


        for (Product item : products){
            ProductResponseDto dto = new ProductResponseDto(item.getProductId(),item.getProductName(),
                                            item.getProductPrice(),item.getProductExpdate());
            response.add(dto);
        }
        return response;
    }




}
