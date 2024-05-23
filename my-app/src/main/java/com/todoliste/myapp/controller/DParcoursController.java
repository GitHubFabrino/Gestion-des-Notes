package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.dto.DParcoursDto;
import com.todoliste.myapp.service.DParcoursService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/dp")
public class DParcoursController {

    @Autowired
    private DParcoursService dParcoursService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post/{idAu}")
    public Message creer(@PathVariable int idAu , @RequestBody DParcoursDto dParcoursDto){
        this.dParcoursService.creer(idAu , dParcoursDto);
        return new Message("Une mention a été creer");
    }

    @GetMapping(path = "/getAll/au/{idAu}")
    public List<DParcoursDto> afficher(@PathVariable int idAu){
        return this.dParcoursService.afficherTous( idAu);
    }

    @GetMapping(path = "/getAll/au/{idAu}/dm/{idDm}/niveau/{idNiv}")
    public List<DParcoursDto> afficher(@PathVariable int idAu , @PathVariable int idDm , @PathVariable int idNiv){
        return this.dParcoursService.afficherTousParMention( idAu , idDm , idNiv);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{iddp}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int iddp ,@RequestBody DParcoursDto dParcoursDto){

        this.dParcoursService.modifier(iddp , dParcoursDto);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{idDP}")
    public Message supprimer(@PathVariable int idDP ){
        this.dParcoursService.supprimer(idDP);
        return new Message("Suppression de l'id : " + idDP +" ok") ;
    }
}
