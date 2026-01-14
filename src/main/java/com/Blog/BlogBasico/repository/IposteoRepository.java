package com.Blog.BlogBasico.repository;

import com.Blog.BlogBasico.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IposteoRepository extends JpaRepository <Posteo, Long> {

}


//public interface IposteoRepository {
//    List<Posteo> findAll();
//    Posteo findById(Long id_Posteo);
//    void save(Posteo posteo);
//}
