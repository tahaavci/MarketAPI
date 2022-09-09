package com.market.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.api.Model.Comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

    public List<Comment> findAllByProductProductId(String productId);

    public List<Comment> findAllByCommentDateBetweenAndProductProductId(LocalDateTime start, LocalDateTime end, String productId);


    public List<Comment> findAllByCustomerCustomerId(String customerId);


    public List<Comment> findAllByCommentDateBetweenAndCustomerCustomerId(LocalDateTime start, LocalDateTime end, String customerId);



}
