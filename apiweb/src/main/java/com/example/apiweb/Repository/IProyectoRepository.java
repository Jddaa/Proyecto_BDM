package com.example.apiweb.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apiweb.Model.ProyectoModel;
import java.util.List;

public interface IProyectoRepository extends JpaRepository<ProyectoModel,Integer> {
    @Query(value = "SELECT * "+
            "FROM Proyecto "+
            "WHERE tipoProyecto = 'Externo'", nativeQuery = true)
    List<ProyectoModel> buscarProyectoExterno();

    @Query( value = "SELECT * "+
            "FROM Proyecto "+
            "WHERE tipoProyecto = 'propio'", nativeQuery = true) 
    List<ProyectoModel> buscarProyectoInterno();
}
