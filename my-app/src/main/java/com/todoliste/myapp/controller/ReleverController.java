package com.todoliste.myapp.controller;

import com.todoliste.myapp.dto.ReleverDTO;
import com.todoliste.myapp.dto.ReleverNoteDTO;
import com.todoliste.myapp.service.Message;
import com.todoliste.myapp.service.ReleverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/relever")
public class ReleverController {

    @Autowired
    private ReleverService releverService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(path = "/post/{iddp}")
    public Message creer(@PathVariable int iddp , @RequestBody ReleverDTO releverDTO){
        this.releverService.creer(iddp , releverDTO);
        return new Message("Succée");
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping(path = "/put/{idrelever}")
    public Message modifier(@PathVariable int idrelever , @RequestBody ReleverNoteDTO releverNoteDTO){
        this.releverService.modifier(idrelever , releverNoteDTO);
        return new Message("Succée");
    }
    @GetMapping(path = "/getAll/relever/{iddp}")
    public List<ReleverDTO> afficher(@PathVariable int iddp){
        return this.releverService.afficherTous( iddp);
    }

}
