package com.example.apiweb.Repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apiweb.Model.IdeaModel;

public interface IIdeaRepository extends JpaRepository<IdeaModel,Integer>{
    @Query(value = "SELECT * FROM IdeaCreativa " +
                    "WHERE dirigida IN ('marketing', 'Freelancing')", nativeQuery = true)
    List<IdeaModel> buscarIdeasPorDir();
    @Query(value = "SELECT * " +
                    "FROM IdeaCreativa " +
                    "WHERE contenido IS NOT NULL", nativeQuery = true)
    List<IdeaModel> buscarIdeasConContenido();
}
