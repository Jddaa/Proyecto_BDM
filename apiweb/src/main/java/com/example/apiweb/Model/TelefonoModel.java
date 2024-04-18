package com.example.apiweb.Model;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Telefono")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoModel {
    @Id
    private BigInteger numTelefono;
    @ManyToOne
    @JoinColumn(name = "idParticipante")
    private ParticipanteModel participante;
    
}
