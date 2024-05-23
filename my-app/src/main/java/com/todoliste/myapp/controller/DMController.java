package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.service.DMService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/dm")
public class DMController {

    @Autowired
    private DMService dmService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post/{idAu}")
    public Message creer(@PathVariable int idAu , @RequestBody DMDto dMdto){
        this.dmService.creer(idAu , dMdto);
        return new Message("Une mention a été creer");
    }
    @GetMapping(path = "/getAll/au/{idAu}")
    public List<DMDto> afficher(@PathVariable int idAu){
        return this.dmService.afficherTous( idAu);
    }

   /* @GetMapping(path = "/get/{id_mention}",produces = APPLICATION_JSON_VALUE)
    public MentionModel lire(@PathVariable int id_mention){

        return this.mentionService.afficherOne(id_mention);
    }*/

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{iddm}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int iddm ,@RequestBody DMDto dmDto){

        this.dmService.modifier(iddm , dmDto);
        return new Message("Modification succée");
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{idDM}")
    public Message supprimer(@PathVariable int idDM ){
        this.dmService.supprimer(idDM);
        return new Message("Suppression de l'id : " + idDM +" ok") ;
    }

}
