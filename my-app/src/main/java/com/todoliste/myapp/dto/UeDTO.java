package com.todoliste.myapp.dto;

import java.math.BigDecimal;

public class UeDTO {
    private Integer idUe;
    private  String nomUe;
    private Integer idDP;
    private BigDecimal creditue ;

    public UeDTO() {
    }

    public UeDTO(Integer idUe, String nomUe, Integer idDP, BigDecimal creditue) {
        this.idUe = idUe;
        this.nomUe = nomUe;
        this.idDP = idDP;
        this.creditue = creditue;
    }

    public UeDTO(String nomUe, Integer idDP, BigDecimal creditue) {
        this.nomUe = nomUe;
        this.idDP = idDP;
        this.creditue = creditue;
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
}

