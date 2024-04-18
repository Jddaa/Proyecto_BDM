package com.example.apiweb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Exception.RecursoNoEncontradoException;
import com.example.apiweb.Model.HaceParteModel;
import com.example.apiweb.Repository.IHaceparteRepository;

@Service
public class IHaceParteServiceImp implements IHaceParteService{

    @Autowired
    IHaceparteRepository haceParteRepository;

    @Override
    public String agregarParticipacion(HaceParteModel participacion) {
        haceParteRepository.save(participacion);
        return "La particpacion con el id " + participacion.getIdFigura() + " fue guardada con exito";
    }

    @Override
    public HaceParteModel buscarParticipacionPorId(int idHaceParte) {
        Optional<HaceParteModel> participacionRecuperada = haceParteRepository.findById(idHaceParte);
        return participacionRecuperada.orElseThrow(() -> new RecursoNoEncontradoException("ParticipacionNoEncontrada"));
    }

    @Override
    public List<HaceParteModel> listarParticipaciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarParticipaciones'");
    }

    @Override
    public String eliminarParticipacionesPorId(int idHaceParte) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarParticipacionesPorId'");
    }

    @Override
    public String actualizarParticipacion(int idHaceParte, HaceParteModel detallesParticipacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParticipacion'");
    }
    
}
