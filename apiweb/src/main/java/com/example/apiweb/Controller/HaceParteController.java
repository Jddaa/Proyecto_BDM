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
import com.example.apiweb.Model.HaceParteModel;
import com.example.apiweb.Service.IHaceParteService;

@RestController
@RequestMapping("/apiweb/proyecto/HaceParte")
public class HaceParteController {
    @Autowired
    IHaceParteService haceParteService;
    @PostMapping("/")
    public ResponseEntity<String> crearParticipacion(@RequestBody HaceParteModel participacion){
        String mensaje = haceParteService.agregarParticipacion(participacion);
        return new ResponseEntity<>(mensaje, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarParticipacionporId(@PathVariable int id){
        try{
            HaceParteModel participacion = haceParteService.buscarParticipacionPorId(id);
            return ResponseEntity.ok(participacion);
        }catch(RecursoNoEncontradoException e){
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<HaceParteModel>> listarIdeas(){
        List<HaceParteModel> participacion = haceParteService.listarParticipaciones();
        return new ResponseEntity<List<HaceParteModel>>(participacion,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarParticipacion(@PathVariable int id){
        try{
            String mensaje = haceParteService.eliminarParticipacionesPorId(id);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> actualizarParticipacionPorId(@PathVariable int id, @RequestBody HaceParteModel detallesParticipacion){
        try{
            String mensaje = haceParteService.actualizarParticipacion(id, detallesParticipacion);
            return ResponseEntity.ok(mensaje);
        }catch(RecursoNoEncontradoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    //No tiene actualizar porque no se puede modificar una primarykey.
}
