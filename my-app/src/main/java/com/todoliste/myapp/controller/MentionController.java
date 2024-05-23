package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.Personne;
import com.todoliste.myapp.service.MentionService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/mention")
public class MentionController {
    @Autowired
    private MentionService mentionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody MentionModel mention){
        this.mentionService.creer(mention);
        return new Message("Une mention a été creer");
    }

    @GetMapping(path = "/getAll")
    public List<MentionModel> afficher(){
        return this.mentionService.afficherTous();
    }

    @GetMapping(path = "/get/{id_mention}",produces = APPLICATION_JSON_VALUE)
    public MentionModel lire(@PathVariable int id_mention){

        return this.mentionService.afficherOne(id_mention);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_mention}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_mention ,@RequestBody MentionModel mention){

        this.mentionService.modifier(id_mention , mention);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_mention}")
    public Message supprimer(@PathVariable int id_mention ){
        this.mentionService.supprimer(id_mention);
        return new Message("Suppression de l'id : " + id_mention +" ok") ;
    }
}
