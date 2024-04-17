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
import com.example.apiweb.Model.ParticipanteModel;
import com.example.apiweb.Service.IParticipanteService;

@RestController
@RequestMapping("/apiweb/proyecto/participante") //enpoint
public class ParticipanteController {
    @Autowired
    IParticipanteService participanteService;
    @PostMapping("/")
    public ResponseEntity<String> crearParticipante(@RequestBody ParticipanteModel participante){
        participanteService.agregarParticipante(participante);
        return new ResponseEntity<String>(participanteService.agregarParticipante(participante),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarParticipantePorId(@PathVariable int id){
        try{
            ParticipanteModel participante = participanteService.buscarParticipantePorId(id);
            return ResponseEntity.ok(participante);
        }catch(RecursoNoEncontradoException e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<ParticipanteModel>> listarParticipantes(){
        List<ParticipanteModel> participantes = participanteService.listarParticipantes();
        return new ResponseEntity<List<ParticipanteModel>>(participantes,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarParticipante(@PathVariable int id){
        try{
            String mensaje = participanteService.eliminarParticipantePorId(id);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
