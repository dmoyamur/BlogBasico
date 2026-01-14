package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Autor;
import com.Blog.BlogBasico.model.Comment;
import com.Blog.BlogBasico.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IcommentService {
    List<Comment> obtenerTodos();
    Optional<Comment> obtenerPorId(Long id);
    void guardarComment(Comment posteo);
    void deleteComment(Long id);
    void editarComment(Long id, Comment commentActualizado);
}
