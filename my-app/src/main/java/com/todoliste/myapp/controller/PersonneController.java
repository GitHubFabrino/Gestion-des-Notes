package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.Personne;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/ajout")
    public Message creer_personne(@RequestBody Personne personne){
        this.personneService.creer(personne);
        return new Message("Succée");
    }


    @GetMapping(path = "/getAll")
    public List<Personne> afficher(){
        return this.personneService.afficherTous();
    }

    @GetMapping(path = "/get/{id_personne}",produces = APPLICATION_JSON_VALUE)
    public Personne lire(@PathVariable int id_personne){

        return this.personneService.afficherOne(id_personne);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_personne}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_personne ,@RequestBody Personne personne){

        this.personneService.modifier_personne(id_personne , personne);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_personne}")
    public Message supprimer(@PathVariable int id_personne ){
        this.personneService.supprimer_personne(id_personne);
        return new Message("Suppression de l'id : " + id_personne +" ok") ;
    }
}
