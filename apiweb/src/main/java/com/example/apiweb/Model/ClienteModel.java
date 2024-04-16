package com.example.apiweb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor 

public class ClienteModel {
   @Id
   private Integer idCliente;
   private String nombre;
   private String email;
}
