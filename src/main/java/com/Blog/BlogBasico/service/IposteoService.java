package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IposteoService {
    List<Posteo> obtenerTodos();
    Optional<Posteo> obtenerPorId(Long id);
    void guardarPosteo(Posteo posteo);
    void deletePosteo(Long id);
    void editarPosteo(Long id, Posteo posteoActualizado);
}
