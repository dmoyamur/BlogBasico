package com.Blog.BlogBasico.repository;

import com.Blog.BlogBasico.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IcommentRepository extends JpaRepository <Comment, Long> {
}
