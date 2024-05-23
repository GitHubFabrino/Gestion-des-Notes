package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.CursusDTO;
import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.models.CursusModel;
import com.todoliste.myapp.service.CursusService;
import com.todoliste.myapp.service.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/cursus")
public class CursusController {

    @Autowired
    private CursusService cursusService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post/dp1/{iddp1}/dp2/{iddp2}")
    public Message creer(@PathVariable int iddp1 ,@PathVariable int iddp2, @RequestBody CursusDTO cursusDTO){
        this.cursusService.creer(iddp1 , iddp2 , cursusDTO);
        return new Message("Une etudiant a été creer");
    }

    @GetMapping(path = "/getAll/dp1/{iddp1}/dp2/{iddp2}")
    public List<CursusDTO> afficher(@PathVariable int iddp1 ,@PathVariable int iddp2){
        return this.cursusService.afficherTous( iddp1 , iddp2);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{idCursus}")
    public Message supprimer(@PathVariable int idCursus ){
        this.cursusService.supprimer(idCursus);
        return new Message("Suppression de l'id : " + idCursus +" ok") ;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/update/etudiant/{idEtudiant}" , consumes = APPLICATION_JSON_VALUE)
    public Message modifier(@PathVariable int idEtudiant ,@RequestBody CursusDTO cursusDTO){

        this.cursusService.modifier(idEtudiant , cursusDTO);
        return new Message("Modification succée");
    }



}
