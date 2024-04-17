package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.IdeaModel;

public interface IIdeaRepository extends JpaRepository<IdeaModel,Integer>{
    
}
