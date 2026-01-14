package com.Blog.BlogBasico.controller;

import com.Blog.BlogBasico.model.Autor;
import com.Blog.BlogBasico.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listaAutores(){
        return autorService.obtenerTodos();
    }

    @GetMapping("{id}")
    public Optional<Autor> listaAutores(Long id){
        return autorService.obtenerPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarAutor(@RequestBody Autor autor){
        autorService.guardarAutor(autor);
        return ResponseEntity.ok("Autor creado exitosamente");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAutor(@PathVariable Long id){
        autorService.deleteAutor(id);
        return ResponseEntity.ok("Autor eliminado exitosamente");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarAutor(@PathVariable Long id, @RequestBody Autor autorActualizado){
        autorService.editarAutor(id,autorActualizado);
        return ResponseEntity.ok("Autor modificado exitosamente");
    }

}
