package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.ParcourModel;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.ParcourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/parcour")
public class ParcoursController {

    @Autowired
    private ParcourService parcourService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody ParcourModel parcour){
        this.parcourService.creer(parcour);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll")
    public List<ParcourModel> afficher(){
        return this.parcourService.afficherTous();
    }

    @GetMapping(path = "/get/{id_parcours}",produces = APPLICATION_JSON_VALUE)
    public ParcourModel lire(@PathVariable int id_parcours){

        return this.parcourService.afficherOne(id_parcours);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_parcours}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_parcours ,@RequestBody ParcourModel parcour){

        this.parcourService.modifier(id_parcours , parcour);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_parcours}")
    public Message supprimer(@PathVariable int id_parcours ){
        this.parcourService.supprimer(id_parcours);
        return new Message("Suppression de l'id : " + id_parcours +" ok") ;
    }
}
