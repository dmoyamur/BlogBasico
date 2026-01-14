package com.Blog.BlogBasico.controller;

import com.Blog.BlogBasico.model.Posteo;
import com.Blog.BlogBasico.service.PosteoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {
    private final PosteoService posteoService;

    public PosteoController(PosteoService posteoService){
        this.posteoService = posteoService;
    }

    @GetMapping
    public List<Posteo> listaPosteos(){
        return posteoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Posteo> obtenerPorId(@PathVariable Long id){
        return posteoService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPosteo(@RequestBody Posteo posteo){
        posteoService.guardarPosteo(posteo);
        return ResponseEntity.ok("Posteo agregado satisfactoriamente");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> deletePosteo(@PathVariable Long id) {
        posteoService.deletePosteo(id);
        return ResponseEntity.ok("Posteo eliminado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPosteo(@PathVariable Long id, @RequestBody Posteo posteoActualizado){
        posteoService.editarPosteo(id, posteoActualizado);
        return  ResponseEntity.ok("Posteo actualizado con exito");
    }

}
