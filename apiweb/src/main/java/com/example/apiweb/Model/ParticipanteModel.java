package com.example.apiweb.Model;

import com.example.apiweb.Model.ENUM.EstadoLider;
import com.example.apiweb.Model.ENUM.TipoParticipante;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Participante")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParticipanteModel {
    @Id
    private Integer idParticipante;
    private String nombre;
    private String correo;  
    private EstadoLider estadoLider;
    private TipoParticipante tipoParticipante;
}
