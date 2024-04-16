package com.example.apiweb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiweb.Model.ParticipanteModel;

public interface IParticipanteRepository extends JpaRepository<ParticipanteModel,Integer>{
    
}
