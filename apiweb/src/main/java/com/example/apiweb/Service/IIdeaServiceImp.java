package com.example.apiweb.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.apiweb.Model.IdeaModel;
import com.example.apiweb.Repository.IIdeaRepository;

public class IIdeaServiceImp implements IIdeaService{
    @Autowired
    IIdeaRepository ideaRepository;
    @Override
    public String agregarIdea(IdeaModel idea){
        ideaRepository.save(idea);
        return "La idea con el id " + idea.getIdIdea() + " fue guardada con exito";
    }
    
}
