package com.example.apiweb.Model;

import com.example.apiweb.Model.ENUM.TipoProyecto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Proyecto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoModel {
    @Id
    private Integer idProyecto;
    @Column(name= "tipoProyecto")
    @Enumerated(EnumType.STRING)
    private TipoProyecto tipoProyecto;
    private String direccion;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private ClienteModel cliente;
    
}
