package com.example.apiweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
