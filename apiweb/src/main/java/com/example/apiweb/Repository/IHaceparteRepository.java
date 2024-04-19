package com.example.apiweb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apiweb.Model.HaceParteModel;

public interface IHaceparteRepository extends JpaRepository<HaceParteModel,Integer> {
    @Query(value = "SELECT * " + 
            "FROM HaceParte " +
            "WHERE fechaFin IS NULL", nativeQuery = true)
    List<HaceParteModel> buscarSinFecha();
    
    @Query(value = "SELECT " +
            "P.nombre AS Nombre_Participante, " +
            "PR.idProyecto AS ID_Proyecto, " +
            "PR.tipoProyecto AS Tipo_Proyecto, " +
            "HP.fechaInicio AS Fecha_Inicio, " +
            "HP.fechaFin AS Fecha_Fin, " +
            "DATEDIFF(HP.fechaFin, HP.fechaInicio) AS Duracion_En_Dias " +
            "FROM " +
            "HaceParte HP " +
            "INNER JOIN " +
            "Participante P ON HP.idParticipante = P.idParticipante " +
            "INNER JOIN " +
            "Proyecto PR ON HP.idProyecto = PR.idProyecto;", nativeQuery = true)
    List<HaceParteModel> buscarParticipantesProyectos();
   

}
