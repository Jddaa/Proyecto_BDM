package com.example.apiweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.Exception.RecursoNoEncontradoException;
import com.example.apiweb.Model.ProyectoModel;
import com.example.apiweb.Service.IProyectoService;

@RestController
@RequestMapping("/apiweb/proyecto/proyecto")
public class ProyectoController {
    @Autowired
    IProyectoService proyectoService;
    @PostMapping("/")
    public ResponseEntity<String> crearProyecto(@RequestBody ProyectoModel proyecto){
        proyectoService.agregarProyecto(proyecto);
        return new ResponseEntity<String>(proyectoService.agregarProyecto(proyecto),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProyectoPorId(@PathVariable int id){
        try{
            ProyectoModel proyecto = proyectoService.buscarProyectoPorId(id);
            return ResponseEntity.ok(proyecto);
        }catch(RecursoNoEncontradoException e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<ProyectoModel>> listarProyecto(){
        List<ProyectoModel> proyectos = proyectoService.listarProyecto();
        return new ResponseEntity<List<ProyectoModel>>(proyectos,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProyecto(@PathVariable int id){
        try{
            String mensaje = proyectoService.eliminarProyectoPorId(id);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> actualizarProyectoPorId(@PathVariable int id, @RequestBody ProyectoModel detallesProyecto){
        try{
            String mensaje = proyectoService.actualizarProyecto(id, detallesProyecto);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
