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
import com.example.apiweb.Model.IdeaModel;
import com.example.apiweb.Service.IIdeaService;

@RestController
@RequestMapping ("/apiweb/proyecto/idea")
public class IdeaController {
    @Autowired
    IIdeaService ideaService;
    @PostMapping("/")
    public ResponseEntity<String> crearIdea(@RequestBody IdeaModel idea){
        String mensaje = ideaService.agregarIdea(idea);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarIdeaPorId(@PathVariable int id){
        try{
            IdeaModel idea = ideaService.buscarIdeaPorId(id);
            return ResponseEntity.ok(idea);
        }catch(RecursoNoEncontradoException e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<IdeaModel>> listarIdeas(){
        List<IdeaModel> ideas = ideaService.listarIdeas();
        return new ResponseEntity<List<IdeaModel>>(ideas,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarIdea(@PathVariable int id){
        try{
            String mensaje = ideaService.eliminarIdeaPorId(id);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> actualizarIdeaPorId(@PathVariable int id, @RequestBody IdeaModel detallesIdea){
        try{
            String mensaje = ideaService.actualizarIdea(id, detallesIdea);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @GetMapping("/dirigida")
    public ResponseEntity<List<IdeaModel>> mostrarIdeasPorDir(){
        List<IdeaModel> ideas = ideaService.mostrarIdeasPorDir();
        return new ResponseEntity<List<IdeaModel>>(ideas,HttpStatus.OK);
    }
    @GetMapping("/contenido")
    public ResponseEntity<List<IdeaModel>> mostrarIdeasConContenido(){
        List<IdeaModel> ideas = ideaService.mostrarIdeasConContenido();
        return new ResponseEntity<List<IdeaModel>>(ideas,HttpStatus.OK);
    }

}
