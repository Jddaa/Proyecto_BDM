package com.example.apiweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.Model.ClienteModel;
import com.example.apiweb.Service.IClienteService;

@RestController
@RequestMapping ("/apiweb/proyecto/cliente")
public class ClienteController {
    @Autowired
    IClienteService clienteService;
    @PostMapping("/")
    public ResponseEntity<String> crearCliente(@RequestBody ClienteModel cliente){
        clienteService.agregarCliente(cliente);
        return new ResponseEntity<String>(clienteService.agregarCliente(cliente),HttpStatus.OK);
    }
}
