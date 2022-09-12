package com.market.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.api.Model.Comment;

import java.time.LocalDateTime;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

    List<Comment> findAllByProductProductId(String productId);

    List<Comment> findAllByCommentDateBetweenAndProductProductId(LocalDateTime start, LocalDateTime end, String productId);


    List<Comment> findAllByCustomerCustomerId(String customerId);


    List<Comment> findAllByCommentDateBetweenAndCustomerCustomerId(LocalDateTime start, LocalDateTime end, String customerId);



}
