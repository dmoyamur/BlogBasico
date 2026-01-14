package com.Blog.BlogBasico.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autor;

    @NotBlank(message="Campo no puede estar vacío")
    String nombre_autor;

    @NotBlank(message="Campo no puede estar vacío")
    @Email(message="Formato de email inválido")
    String email_autor;

    //One to Many: Un autor puede tener muchos post
    @OneToMany(mappedBy = "autorPost", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Posteo> posteos;


    public Autor() {
    }

    public Autor(Long id_autor, String nombre_autor, String email_autor) {
        this.id_autor = id_autor;
        this.nombre_autor = nombre_autor;
        this.email_autor = email_autor;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getEmail_autor() {
        return email_autor;
    }

    public void setEmail_autor(String email_autor) {
        this.email_autor = email_autor;
    }
}
