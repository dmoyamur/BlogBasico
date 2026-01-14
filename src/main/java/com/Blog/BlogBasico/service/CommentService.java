package com.Blog.BlogBasico.service;

import com.Blog.BlogBasico.model.Comment;
import com.Blog.BlogBasico.model.Posteo;
import com.Blog.BlogBasico.repository.IcommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements IcommentService{
    private final IcommentRepository commentRepository;

    @Autowired
    public CommentService(IcommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> obtenerTodos() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> obtenerPorId(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void guardarComment(Comment posteo) {
        commentRepository.save(posteo);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void editarComment(Long id, Comment commentActualizado) {
        Comment commentExistente = commentRepository.findById(id).orElse(null);

        if (commentExistente != null) {
            //Actualizar los campos del comment existente
            commentExistente.setTextComment(commentActualizado.getTextComment());
            commentExistente.setCreatedAt(commentActualizado.getCreatedAt());

            // Guardo el comment actualizado
            commentRepository.save(commentExistente);
        } else {
            throw new RuntimeException("Comment no encontrado con el id: " + id);
        }

    }
}
