package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.ProyectoModel;

public interface IProyectoRepository extends JpaRepository<ProyectoModel,Integer> {
    
}
