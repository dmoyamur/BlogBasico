package com.Blog.BlogBasico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Posteos")
public class Posteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Posteo;

    @NotBlank(message="Campo no puede estar vacío")
    @Size(max=100)
    private String titulo;

    @NotBlank(message="El autor es obligatorio")
    private String autor;

    @NotNull(message="Campo no puede estar vacío")
    private LocalDate fecha;

    //One to Many: Un post puede tener varios comentarios
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comment> comments;

    //Many to One: Muchos posteos pueden tener un autor
    @ManyToOne
    @JoinColumn(name="id_autor")
    @JsonBackReference
    private Autor autorPost;



    public Posteo() {
    }

    public Posteo(Long id_Posteo, String titulo, String autor, LocalDate fecha) {
        this.id_Posteo = id_Posteo;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
    }

    public Long getId_Posteo() {
        return id_Posteo;
    }

    public void setId_Posteo(Long id_Posteo) {
        this.id_Posteo = id_Posteo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
