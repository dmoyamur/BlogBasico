package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Posteo;
import com.Blog.BlogBasico.repository.IposteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteoService implements IposteoService{
    private final IposteoRepository posteoRepository;

    @Autowired
    public PosteoService(IposteoRepository posteoRepository) {
        this.posteoRepository = posteoRepository;
    }

    @Override
    public List<Posteo> obtenerTodos() {
        return posteoRepository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        return posteoRepository.findById(id);
    }

    @Override
    public void guardarPosteo(Posteo posteo) {
        posteoRepository.save(posteo);
    }

    @Override
    public void deletePosteo(Long id) {
        posteoRepository.deleteById(id);
    }

    @Override
    public void editarPosteo(Long id, Posteo posteoActualizado) {
        Posteo posteoExistente = posteoRepository.findById(id).orElse(null);

        if (posteoExistente != null) {
            //Actualizar los campos del post existente
            posteoExistente.setTitulo(posteoActualizado.getTitulo());
            posteoExistente.setAutor(posteoActualizado.getAutor());
            posteoExistente.setFecha(posteoActualizado.getFecha());

            // Guardo el posteo actualziado
            posteoRepository.save(posteoExistente);
        } else {
            throw new RuntimeException("Posteo no encontrado con el id: " + id);
        }
    }
}
