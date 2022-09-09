package com.market.api.Dto;

import com.market.api.Model.Comment;
import com.market.api.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class TypeConvertion {


    public static List<CommentDto> ConvertToCommentDto(List<Comment> comments){

        List<CommentDto> response = new ArrayList<>();


        for (Comment item : comments){
            CommentDto dto = new CommentDto(item.getCommentId(),item.getCommentContent()
                                            ,item.getCommentDate(),item.getCustomer().getCustomerId());
            response.add(dto);
        }
        return response;
    }


    public static List<ProductDto> ConvertToProductDto(List<Product> products){

        List<ProductDto> response = new ArrayList<>();


        for (Product item : products){
            ProductDto dto = new ProductDto(item.getProductId(),item.getProductName(),
                                            item.getProductPrice(),item.getProductExpdate());
            response.add(dto);
        }
        return response;
    }




}
