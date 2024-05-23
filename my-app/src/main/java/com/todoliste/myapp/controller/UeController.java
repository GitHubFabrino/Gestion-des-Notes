package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.UeDTO;
import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.UeModel;
import com.todoliste.myapp.service.MentionService;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.UeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/ue")
public class UeController {

    @Autowired
    private UeService ueService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody UeDTO ue){
        this.ueService.creer(ue);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll/dp/{idDp}")
    public List<UeDTO> afficher(@PathVariable int idDp){
        return this.ueService.afficherTous( idDp);
    }

    @GetMapping(path = "/get/{id_Ue}",produces = APPLICATION_JSON_VALUE)
    public UeModel lire(@PathVariable int id_Ue){

        return this.ueService.afficherOne(id_Ue);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/{id_Ue}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int id_Ue ,@RequestBody UeDTO ue){

        this.ueService.modifier(id_Ue , ue);
        return new Message("Modification succée");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{id_Ue}")
    public Message supprimer(@PathVariable int id_Ue ){
        this.ueService.supprimer(id_Ue);
        return new Message("Suppression de l'id : " + id_Ue +" ok") ;
    }
}
