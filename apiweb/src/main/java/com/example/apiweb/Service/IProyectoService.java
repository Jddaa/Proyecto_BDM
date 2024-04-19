package com.example.apiweb.Service;

import java.util.List;

import com.example.apiweb.Model.ProyectoModel;

public interface IProyectoService {
    String agregarProyecto(ProyectoModel proyecto);
    ProyectoModel buscarProyectoPorId(int idProyecto);
    List<ProyectoModel>listarProyecto();
    String eliminarProyectoPorId(int idProyecto);
    String actualizarProyecto(int idProyecto, ProyectoModel detallesProyecto);
    List<ProyectoModel> mostrarProyectoExterno();
    List<ProyectoModel> mostrarProyectoInterno();
} 
