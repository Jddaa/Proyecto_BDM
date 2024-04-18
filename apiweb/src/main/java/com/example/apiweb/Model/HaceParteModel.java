package com.example.apiweb.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "HaceParte")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HaceParteModel {
    @Id
    private Integer idFigura;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name="idParticipante")
    private ParticipanteModel participante;

    @ManyToOne
    @JoinColumn(name="idProyecto")
    private ProyectoModel proyecto;
}
