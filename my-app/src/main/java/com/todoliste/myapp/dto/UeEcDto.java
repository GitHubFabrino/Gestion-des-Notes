package com.todoliste.myapp.dto;

import java.math.BigDecimal;

public class UeEcDto {

    private Integer idUeEc;
    private Integer idUe ;
    private Integer idEc;
    private String matiere;
    private BigDecimal creditec ;
    private BigDecimal coefec;

    public UeEcDto() {
    }

    public UeEcDto(Integer idUeEc, Integer idUe, Integer idEc, String matiere, BigDecimal creditec, BigDecimal coefec) {
        this.idUeEc = idUeEc;
        this.idUe = idUe;
        this.idEc = idEc;
        this.matiere = matiere;
        this.creditec = creditec;
        this.coefec = coefec;
    }

    public UeEcDto(Integer idUe, Integer idEc, String matiere, BigDecimal creditec, BigDecimal coefec) {
        this.idUe = idUe;
        this.idEc = idEc;
        this.matiere = matiere;
        this.creditec = creditec;
        this.coefec = coefec;
    }

    public UeEcDto(Integer idUe, String matiere, BigDecimal creditec, BigDecimal coefec) {
        this.idUe = idUe;
        this.matiere = matiere;
        this.creditec = creditec;
        this.coefec = coefec;
    }

    public Integer getIdUeEc() {
        return idUeEc;
    }

    public void setIdUeEc(Integer idUeEc) {
        this.idUeEc = idUeEc;
    }

    public Integer getIdUe() {
        return idUe;
    }

    public void setIdUe(Integer idUe) {
        this.idUe = idUe;
    }

    public Integer getIdEc() {
        return idEc;
    }

    public void setIdEc(Integer idEc) {
        this.idEc = idEc;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public BigDecimal getCreditec() {
        return creditec;
    }

    public void setCreditec(BigDecimal creditec) {
        this.creditec = creditec;
    }

    public BigDecimal getCoefec() {
        return coefec;
    }

    public void setCoefec(BigDecimal coefec) {
        this.coefec = coefec;
    }
}
