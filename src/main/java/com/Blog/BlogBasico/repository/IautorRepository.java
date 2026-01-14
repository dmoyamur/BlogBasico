package com.Blog.BlogBasico.repository;

import com.Blog.BlogBasico.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IautorRepository extends JpaRepository <Autor, Long> {
}
