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
        
        return haceParteRepository.findAll();
    }

    @Override
    public String eliminarParticipacionesPorId(int idHaceParte) {
        
        Optional<HaceParteModel> participacionRecuperada = haceParteRepository.findById(idHaceParte);
        this.haceParteRepository.deleteById(idHaceParte);
        return "La participación de ID " + participacionRecuperada.get().getIdFigura() + "fue eliminada con exito";
    }

    @Override
    public String actualizarParticipacion(int idHaceParte, HaceParteModel detallesParticipacion) {
       
        throw new UnsupportedOperationException("Unimplemented method 'actualizarParticipacion'");
    }

    @Override
    public List<HaceParteModel> mostrarSinFecha() {
        return haceParteRepository.buscarSinFecha();
    }
    @Override   
    public List<HaceParteModel> mostrarParticipantesProyectos() {
        return haceParteRepository.buscarParticipantesProyectos();
    }
}
