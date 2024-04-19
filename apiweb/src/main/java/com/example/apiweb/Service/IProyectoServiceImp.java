package com.example.apiweb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Exception.RecursoNoEncontradoException;
import com.example.apiweb.Model.ProyectoModel;
import com.example.apiweb.Repository.IProyectoRepository;

@Service
public class IProyectoServiceImp implements IProyectoService{
    @Autowired
    IProyectoRepository proyectoRepository;
   
    @Override 
    public String agregarProyecto(ProyectoModel proyecto) {
        proyectoRepository.save(proyecto);
        return "El Proyecto con la id " + proyecto.getIdProyecto() + " fue guardado con exito";
    }

    @Override
    public ProyectoModel buscarProyectoPorId(int idProyecto) {
        Optional<ProyectoModel> proyectoRecuperado = proyectoRepository.findById(idProyecto);
        return proyectoRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("ProyecyoNoEncontrado"));
    }

    @Override
    public List<ProyectoModel> listarProyecto() {
        return proyectoRepository.findAll();
    }

    @SuppressWarnings("unused")
    @Override
    public String eliminarProyectoPorId(int idProyecto) {
        Optional<ProyectoModel> proyectoRecuperado = proyectoRepository.findById(idProyecto);
        if(proyectoRecuperado != null){
            proyectoRepository.deleteById(idProyecto);
            return "Proyecto eliminado";
        }else{
            return "El proyecto no existe en la base de datos";
        }
    }

    @Override
    public String actualizarProyecto(int idProyecto, ProyectoModel detallesProyecto) {
        Optional<ProyectoModel> proyectoRecuperado = proyectoRepository.findById(idProyecto);
        if(proyectoRecuperado.isPresent()){
            ProyectoModel proyecto = proyectoRecuperado.get();
            if(detallesProyecto.getTipoProyecto() != null){
                proyecto.setTipoProyecto(detallesProyecto.getTipoProyecto());
            }
            if(detallesProyecto.getDireccion() != null){
                proyecto.setDireccion(detallesProyecto.getDireccion());
            }
            if(detallesProyecto.getTipoProyecto() != null){
                proyecto.setTipoProyecto(detallesProyecto.getTipoProyecto());
            }

            proyectoRepository.save(proyecto);
            return "Proyecto Actualizado";
    }else{
        return "Error, no se encontro el proyecto con el id" + idProyecto;
    }
}

    @Override
    public List<ProyectoModel> mostrarProyectoExterno() {
        return proyectoRepository.buscarProyectoExterno();
    }

    @Override
    public List<ProyectoModel> mostrarProyectoInterno() {
        return proyectoRepository.buscarProyectoInterno();
    }
    
}
