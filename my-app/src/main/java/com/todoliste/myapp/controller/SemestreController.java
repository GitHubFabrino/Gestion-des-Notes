package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.SemestreModel;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.SemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/semestre")
public class SemestreController {

    @Autowired
    private SemestreService semestreService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody SemestreModel semestre){
        this.semestreService.creer(semestre);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll")
    public List<SemestreModel> afficher(){
        return this.semestreService.afficherTous();
    }

    @GetMapping(path = "/get/{id_semestre}",produces = APPLICATION_JSON_VALUE)
    public SemestreModel lire(@PathVariable int id_semestre){

        return this.semestreService.afficherOne(id_semestre);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_semestre}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_semestre ,@RequestBody SemestreModel semestre){

        this.semestreService.modifier(id_semestre , semestre);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_semestre}")
    public Message supprimer(@PathVariable int id_semestre ){
        this.semestreService.supprimer(id_semestre);
        return new Message("Suppression de l'id : " + id_semestre +" ok") ;
    }
}
