package com.example.apiweb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Exception.RecursoNoEncontradoException;
import com.example.apiweb.Model.IdeaModel;
import com.example.apiweb.Repository.IIdeaRepository;

@Service
public class IIdeaServiceImp implements IIdeaService{
    @Autowired
    IIdeaRepository ideaRepository;
    @Override
    public String agregarIdea(IdeaModel idea){
        ideaRepository.save(idea);
        return "La idea con el id " + idea.getIdIdea() + " fue guardada con exito";
    }
    @Override
    public IdeaModel buscarIdeaPorId(int idIdea) {
        Optional<IdeaModel> ideaRecuperada = ideaRepository.findById(idIdea);
        return ideaRecuperada.orElseThrow(() -> new RecursoNoEncontradoException("IdeaNoEncontrada"));
    }
    @Override
    public List<IdeaModel> listarIdeas() {
        return ideaRepository.findAll();
    }
    @SuppressWarnings("unused")
    @Override
    public String eliminarIdeaPorId(int idIdea) {
        Optional<IdeaModel> ideaRecuperada = ideaRepository.findById(idIdea);
        if(ideaRecuperada != null){
            ideaRepository.deleteById(idIdea);
            return "Idea eliminada";
        }else{
            return "La idea no existe en la base de datos";
        }
    }
    @Override
    public String actualizarIdea(int idIdea, IdeaModel detallesIdea) {
        Optional<IdeaModel> ideaRecuperada = ideaRepository.findById(idIdea);
        if(ideaRecuperada.isPresent()){
            IdeaModel idea = ideaRecuperada.get();
            if(detallesIdea.getContenido() != null){
                idea.setContenido(detallesIdea.getContenido());
            }
            if(detallesIdea.getParticipante() != null){
                idea.setParticipante(detallesIdea.getParticipante());
            }
            if(detallesIdea.getProyecto() != null){
                idea.setProyecto(detallesIdea.getProyecto());
            }
            if(detallesIdea.getDirigida() != null){
                idea.setDirigida(detallesIdea.getDirigida());
            }
            ideaRepository.save(idea);
            return "Idea Actualizada";
        }else{
            return "Error, no se encontro la idea con el id" + idIdea;
        }
    }
    
}
