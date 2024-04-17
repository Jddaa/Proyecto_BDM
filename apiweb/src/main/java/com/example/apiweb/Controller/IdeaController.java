package com.example.apiweb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiweb.Model.IdeaModel;
import com.example.apiweb.Service.IIdeaService;

@RestController
@RequestMapping ("/apiweb/proyecto/idea")
public class IdeaController {
    @Autowired
    IIdeaService ideaService;
    @PostMapping("/")
    public ResponseEntity<String> crearIdea(@RequestBody IdeaModel idea){
        ideaService.agregarIdea(idea);
        return new ResponseEntity<String>(ideaService.agregarIdea(idea),HttpStatus.OK);
    }
}
