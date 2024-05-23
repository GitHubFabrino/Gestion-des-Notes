package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.NiveauModel;
import com.todoliste.myapp.service.MentionService;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/niveau")
public class NiveauController {

    @Autowired
    private NiveauService niveauService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody NiveauModel niveau){
        this.niveauService.creer(niveau);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll")
    public List<NiveauModel> afficher(){
        return this.niveauService.afficherTous();
    }

    @GetMapping(path = "/get/{id_niveau}",produces = APPLICATION_JSON_VALUE)
    public NiveauModel lire(@PathVariable int id_niveau){

        return this.niveauService.afficherOne(id_niveau);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_niveau}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_niveau ,@RequestBody NiveauModel niveau){

        this.niveauService.modifier(id_niveau , niveau);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_niveau}")
    public Message supprimer(@PathVariable int id_niveau ){
        this.niveauService.supprimer(id_niveau);
        return new Message("Suppression de l'id : " + id_niveau +" ok") ;
    }
}
