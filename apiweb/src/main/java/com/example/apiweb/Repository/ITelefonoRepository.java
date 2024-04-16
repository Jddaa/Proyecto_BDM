package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.TelefonoModel;

public interface ITelefonoRepository extends JpaRepository<TelefonoModel,Integer>{
    
}
