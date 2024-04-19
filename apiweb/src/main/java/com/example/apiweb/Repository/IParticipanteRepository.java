package com.example.apiweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apiweb.Model.ParticipanteModel;

public interface IParticipanteRepository extends JpaRepository<ParticipanteModel, Integer>{

    @Query (value="SELECT *" +
            "FROM Participante " +
            "WHERE tipoParticipante = 'interno' AND estadoLider = 'no'", nativeQuery = true)
    List<ParticipanteModel> buscarInternoNoLider();
    @Query (value = "SELECT * "+
            "FROM Participante "+ 
            "WHERE tipoParticipante = 'externo'", nativeQuery = true)
    List<ParticipanteModel> mostrarExterno();
}
