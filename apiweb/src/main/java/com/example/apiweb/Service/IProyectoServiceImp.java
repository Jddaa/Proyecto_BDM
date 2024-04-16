package com.example.apiweb.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.apiweb.Model.ProyectoModel;
import com.example.apiweb.Repository.IProyectoRepository;

public class IProyectoServiceImp implements IProyectoService{
    @Autowired
    IProyectoRepository proyectoRepository;
   
    @Override 
    public String agregarProyecto(ProyectoModel proyecto) {
        proyectoRepository.save(proyecto);
        return "El Cliente con la id " + proyecto.getCliente().getIdCliente() + " fue guardado con exito";
    }
}
