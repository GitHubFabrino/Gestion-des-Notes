package com.todoliste.myapp.dto;

import com.todoliste.myapp.models.DefinitionMentionModel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UeEcListDTO {

    private Integer idUe;
    private  String nomUe;
    private Integer idDP;
    private BigDecimal creditue ;

    ArrayList<UeEcDto> ueEcDtos;

    public UeEcListDTO() {
    }

    public UeEcListDTO(Integer idUe, String nomUe, Integer idDP, BigDecimal creditue, ArrayList<UeEcDto> ueEcDtos) {
        this.idUe = idUe;
        this.nomUe = nomUe;
        this.idDP = idDP;
        this.creditue = creditue;
        this.ueEcDtos = ueEcDtos;
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

    public Integer getIdDP() {
        return idDP;
    }

    public void setIdDP(Integer idDP) {
        this.idDP = idDP;
    }

    public BigDecimal getCreditue() {
        return creditue;
    }

    public void setCreditue(BigDecimal creditue) {
        this.creditue = creditue;
    }

    public ArrayList<UeEcDto> getUeEcDtos() {
        return ueEcDtos;
    }

    public void setUeEcDtos(ArrayList<UeEcDto> ueEcDtos) {
        this.ueEcDtos = ueEcDtos;
    }
}
