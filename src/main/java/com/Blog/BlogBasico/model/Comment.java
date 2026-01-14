package com.Blog.BlogBasico.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;

    @NotBlank(message="Campo no puede estar vacío")
    String textComment;

    @NotNull(message="Campo no puede estar vacío")
    LocalDate createdAt;


    //Many to One: Muchos comentarios pueden tener un posteo
    @ManyToOne
    @JoinColumn(name="id_Posteo")
    @JsonBackReference

    private Posteo post;

    public Comment() {
    }

    public Comment(Long idComment, String textComment, LocalDate createdAt) {
        this.idComment = idComment;
        this.textComment = textComment;
        this.createdAt = createdAt;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
