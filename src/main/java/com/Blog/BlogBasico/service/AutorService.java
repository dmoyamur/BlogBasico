package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Autor;
import com.Blog.BlogBasico.model.Comment;
import com.Blog.BlogBasico.model.Posteo;
import com.Blog.BlogBasico.repository.IautorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements  IautorService{
    private final IautorRepository autorRepository;

    @Autowired
    public AutorService(IautorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> obtenerTodos() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> obtenerPorId(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public void guardarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public void editarAutor(Long id, Autor autorActualizado) {
        Autor autorExistente = autorRepository.findById(id).orElse(null);

        if (autorExistente != null) {
            //Actualizar los campos del comment existente
            autorExistente.setNombre_autor(autorActualizado.getNombre_autor());
            autorExistente.setEmail_autor(autorActualizado.getEmail_autor());

            // Guardo el comment actualizado
            autorRepository.save(autorExistente);
        } else {
            throw new RuntimeException("Comment no encontrado con el id: " + id);
        }
    }
}
