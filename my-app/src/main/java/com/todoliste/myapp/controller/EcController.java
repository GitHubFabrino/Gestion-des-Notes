package com.todoliste.myapp.controller;

import com.todoliste.myapp.models.EcModel;
import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.service.EcService;
import com.todoliste.myapp.service.MentionService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/ec")
public class EcController {
    @Autowired
    private EcService ecService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody EcModel ec){
        this.ecService.creer(ec);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll")
    public List<EcModel> afficher(){
        return this.ecService.afficherTous();
    }

    @GetMapping(path = "/get/{id_ec}",produces = APPLICATION_JSON_VALUE)
    public EcModel lire(@PathVariable int id_ec){

        return this.ecService.afficherOne(id_ec);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_ec}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_ec ,@RequestBody EcModel ec){

        this.ecService.modifier(id_ec , ec);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_ec}")
    public Message supprimer(@PathVariable int id_ec ){
        this.ecService.supprimer(id_ec);
        return new Message("Suppression de l'id : " + id_ec +" ok") ;
    }
}
