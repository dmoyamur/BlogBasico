package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Autor;
import com.Blog.BlogBasico.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IautorService {
    List<Autor> obtenerTodos();
    Optional<Autor> obtenerPorId(Long id);
    void guardarAutor(Autor posteo);
    void deleteAutor(Long id);
    void editarAutor(Long id, Autor autorActualizado);
}
