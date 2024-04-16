package com.example.apiweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.Model.ParticipanteModel;
import com.example.apiweb.Service.IParticipanteService;

@RestController
@RequestMapping("/apiweb/proyecto/participante") //enpoint
public class ParticipanteController {
    @Autowired
    IParticipanteService participanteService;
    @PostMapping
    public ResponseEntity<String> crearParticipante(@RequestBody ParticipanteModel participante){
        participanteService.agregarParticipante(participante);
        return new ResponseEntity<String>(participanteService.agregarParticipante(participante),HttpStatus.OK);
    }
}
