package com.todoliste.myapp.controller;


import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.Personne;
import com.todoliste.myapp.service.AnneeUniversitaireService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/Au")
public class AnneeUniversitaireController {
    @Autowired
    private AnneeUniversitaireService anneeUniversitaireService;


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer_Au(@RequestBody AnneeUniversitaireModel anneeUniversitaire){
        this.anneeUniversitaireService.creer(anneeUniversitaire);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll")
    public List<AnneeUniversitaireModel> afficher(){
        return this.anneeUniversitaireService.afficherTous();
    }

    @GetMapping(path = "/get/{id_au}",produces = APPLICATION_JSON_VALUE)
    public AnneeUniversitaireModel lire(@PathVariable int id_au){

        return this.anneeUniversitaireService.afficherOne(id_au);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_au}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_au ,@RequestBody AnneeUniversitaireModel anneeUniversitaire){

        this.anneeUniversitaireService.modifier_au(id_au , anneeUniversitaire);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_au}")
    public Message supprimer(@PathVariable int id_au ){
        this.anneeUniversitaireService.supprimer_Au(id_au);
        return new Message("Suppression de l'id : " + id_au +" ok") ;
    }

}
