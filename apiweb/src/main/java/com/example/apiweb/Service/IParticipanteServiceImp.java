package com.example.apiweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Model.ParticipanteModel;
import com.example.apiweb.Repository.IParticipanteRepository;

@Service
public class IParticipanteServiceImp implements IParticipanteService{
    @Autowired
    IParticipanteRepository participanteRepository;
    @Override
    public String agregarParticipante(ParticipanteModel participante) {
        participanteRepository.save(participante);
        return "El participante con la id " + participante.getIdParticipante() + " fue guardado con exito";
    }
    
}
