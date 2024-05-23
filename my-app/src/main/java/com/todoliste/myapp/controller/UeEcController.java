package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.dto.UeEcDto;
import com.todoliste.myapp.dto.UeEcListDTO;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.UeEcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/ueec")
public class UeEcController {

    @Autowired
    private UeEcService ueEcService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "/post")
    public Message creer(@RequestBody UeEcDto ueEcDto){
        this.ueEcService.creer(ueEcDto);
        return new Message("Succée");
    }

    @GetMapping(path = "/getAll/dp/{iddp}")
    public List<UeEcListDTO> afficher(@PathVariable int iddp){
        return this.ueEcService.afficherTous( iddp);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(path = "/delete/{idueec}")
    public Message supprimer(@PathVariable int idueec ){
        this.ueEcService.supprimer(idueec);
        return new Message("Suppression de l'id : " + idueec +" ok") ;
    }


}
