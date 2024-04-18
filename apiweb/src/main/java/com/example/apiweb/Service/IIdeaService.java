package com.example.apiweb.Service;

import java.util.List;

import com.example.apiweb.Model.IdeaModel;

public interface IIdeaService {
    String agregarIdea(IdeaModel idea);
    IdeaModel buscarIdeaPorId(int idIdea);
    List<IdeaModel>listarIdeas();
    String eliminarIdeaPorId(int idIdea);
    String actualizarIdea(int idIdea, IdeaModel detallesIdea);
}
