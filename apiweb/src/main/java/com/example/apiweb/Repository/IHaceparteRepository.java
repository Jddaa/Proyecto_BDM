package com.example.apiweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apiweb.Model.HaceParteModel;

public interface IHaceparteRepository extends JpaRepository<HaceParteModel,Integer> {
    @Query(value = "SELECT * "+
            "FROM HaceParte "+
            "WHERE idProyecto = ?1", nativeQuery = true)
    List<HaceParteModel> buscarPerteneceMenorQueUno();
}
