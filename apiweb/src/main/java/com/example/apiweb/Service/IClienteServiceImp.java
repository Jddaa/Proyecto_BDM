package com.example.apiweb.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiweb.Model.ClienteModel;
import com.example.apiweb.Repository.IClienteRepository;

@Service
public class IClienteServiceImp implements IClienteService{

    @Autowired
    IClienteRepository clienteRepository;
   
    @Override 
    public String agregarCliente(ClienteModel cliente) {
        clienteRepository.save(cliente);
        return "El cliente con la id " + cliente.getIdCliente() + " fue guardado con exito";
    }

    
}
