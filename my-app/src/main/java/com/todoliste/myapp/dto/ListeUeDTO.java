package com.todoliste.myapp.dto;

import java.util.ArrayList;

public class ListeUeDTO {
    private Integer idUe;
    private  String nomUe;
    ArrayList<ReleverNoteDTO> releverNoteDTOS;

    public ListeUeDTO(Integer idUe, String nomUe, ArrayList<ReleverNoteDTO> releverNoteDTOS) {
        this.idUe = idUe;
        this.nomUe = nomUe;
        this.releverNoteDTOS = releverNoteDTOS;
    }

    public Integer getIdUe() {
        return idUe;
    }

    public void setIdUe(Integer idUe) {
        this.idUe = idUe;
    }

    public String getNomUe() {
        return nomUe;
    }

    public void setNomUe(String nomUe) {
        this.nomUe = nomUe;
    }

    public ArrayList<ReleverNoteDTO> getReleverNoteDTOS() {
        return releverNoteDTOS;
    }

    public void setReleverNoteDTOS(ArrayList<ReleverNoteDTO> releverNoteDTOS) {
        this.releverNoteDTOS = releverNoteDTOS;
    }
}
