package com.example.apiweb.Service;

import java.util.List;

import com.example.apiweb.Model.ParticipanteModel;

public interface IParticipanteService {
    String agregarParticipante(ParticipanteModel participante);
    ParticipanteModel buscarParticipantePorId(int idParticipante);
    List<ParticipanteModel>listarParticipantes();
    String eliminarParticipantePorId(int idParticipante);
    String actualizarParticipante(int idParticipante, ParticipanteModel detallesparticipante);
    List<ParticipanteModel> mostrarInternoNoLider();
    //otras cosas
}
