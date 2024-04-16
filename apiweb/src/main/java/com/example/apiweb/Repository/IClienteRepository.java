package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.ClienteModel;

public interface IClienteRepository extends JpaRepository<ClienteModel,Integer>{
    
}
