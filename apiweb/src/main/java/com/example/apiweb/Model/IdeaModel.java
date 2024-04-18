package com.example.apiweb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "IdeaCreativa")
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class IdeaModel {
    @Id
    private Integer idIdea;
    private String contenido;
    @ManyToOne
    @JoinColumn(name = "idParticipante")
    private ParticipanteModel participante;
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private ProyectoModel proyecto;
    private String dirigida;
}
