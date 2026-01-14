package com.Blog.BlogBasico.controller;

import com.Blog.BlogBasico.model.Comment;
import com.Blog.BlogBasico.model.Posteo;
import com.Blog.BlogBasico.service.CommentService;
import com.Blog.BlogBasico.service.IcommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> listaComments(){
        return commentService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Comment> obtenerPorId(Long id){
        return commentService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarComment(@RequestBody Comment comment){
        commentService.guardarComment(comment);
        return ResponseEntity.ok("Comment agregado satisfactoriamente");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok("Comment eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarComment(@PathVariable Long id, @RequestBody Comment commentActualizado){
        commentService.editarComment(id, commentActualizado);
        return  ResponseEntity.ok("Comment actualizada con exito");
    }
}
