package com.example.apiweb.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Exception.RecursoNoEncontradoException;
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
    @Override
    public ParticipanteModel buscarParticipantePorId(int idParticipante) {
        Optional<ParticipanteModel> participanteRecuperado = participanteRepository.findById(idParticipante);
        return participanteRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("ParticipanteNoEncontrado"));
    }
    @Override
    public List<ParticipanteModel> listarParticipantes() {
        return participanteRepository.findAll();
    }
    @Override
    public String eliminarParticipantePorId(int idParticipante) {
        Optional<ParticipanteModel> participanteRecuperado = participanteRepository.findById(idParticipante);
        if(participanteRecuperado != null){
            participanteRepository.deleteById(idParticipante);
            return "Partipante eliminado";
        }else{
            return "El participante no existe en la base de datos";
        }
    }
    @Override
    public String actualizarParticipante(int idParticipante, ParticipanteModel detallesparticipante) {
        Optional<ParticipanteModel> participanteRecuperado = participanteRepository.findById(idParticipante);
        if(participanteRecuperado.isPresent()){
            ParticipanteModel participante = participanteRecuperado.get();
            if(detallesparticipante.getNombre() != null){
                participante.setNombre(detallesparticipante.getNombre());
            }
            if(detallesparticipante.getCorreo() != null){
                participante.setCorreo(detallesparticipante.getCorreo());
            }
            if(detallesparticipante.getEstadoLider() != null){
                participante.setEstadoLider(detallesparticipante.getEstadoLider());
            }
            if(detallesparticipante.getTipoParticipante() != null){
                participante.setIdParticipante(detallesparticipante.getIdParticipante());
            }

        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParticipante'");
    }
    
}
