package com.example.apiweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.Model.TelefonoModel;
import com.example.apiweb.Service.ITelefonoService;

@RestController
@RequestMapping("/apiweb/proyecto/telefono")
public class TelefonoController {
    @Autowired
    ITelefonoService telefonoService;
    @PostMapping("/")
    public ResponseEntity<String> crearTelefono(@RequestBody TelefonoModel telefono){
        telefonoService.agregarTelefono(telefono);
        return new ResponseEntity<String>(telefonoService.agregarTelefono(telefono),HttpStatus.OK);
    }
}
