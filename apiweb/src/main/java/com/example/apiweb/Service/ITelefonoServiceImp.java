package com.example.apiweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Model.TelefonoModel;
import com.example.apiweb.Repository.ITelefonoRepository;

@Service
public class ITelefonoServiceImp implements ITelefonoService{
    @Autowired
    ITelefonoRepository telefonoRepository;
    @Override
    public String agregarTelefono(TelefonoModel telefono) {
        telefonoRepository.save(telefono);
        return "El telefono del Participante con el id " + telefono.getParticipante().getIdParticipante() + " ha sido agregado";  
    }
    
}
