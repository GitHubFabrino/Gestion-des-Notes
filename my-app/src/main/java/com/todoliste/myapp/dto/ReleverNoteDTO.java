package com.todoliste.myapp.dto;

import java.math.BigDecimal;

public class ReleverNoteDTO {
    private Integer id_Relever;
    private Integer idCursus;
    private Integer idUeEc;
    private BigDecimal note;
    private String NomMatiere;

    public ReleverNoteDTO() {
    }

    public ReleverNoteDTO(Integer idUeEc, BigDecimal note) {
        this.idUeEc = idUeEc;
        this.note = note;
    }

    public ReleverNoteDTO(Integer id_Relever, Integer idCursus, BigDecimal note, Integer idUeEc, String nomMatiere) {
        this.id_Relever = id_Relever;
        this.idCursus = idCursus;
        this.note = note;
        this.idUeEc = idUeEc;
        NomMatiere = nomMatiere;
    }

    public ReleverNoteDTO(BigDecimal note) {
        this.note = note;
    }

    public Integer getId_Relever() {
        return id_Relever;
    }

    public void setId_Relever(Integer id_Relever) {
        this.id_Relever = id_Relever;
    }

    public Integer getIdCursus() {
        return idCursus;
    }

    public void setIdCursus(Integer idCursus) {
        this.idCursus = idCursus;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }

    public Integer getIdUeEc() {
        return idUeEc;
    }

    public void setIdUeEc(Integer idUeEc) {
        this.idUeEc = idUeEc;
    }

    public String getNomMatiere() {
        return NomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        NomMatiere = nomMatiere;
    }

    @Override
    public String toString() {
        return "ReleverNoteDTO{" +
                "id_Relever=" + id_Relever +
                ", idCursus=" + idCursus +
                ", idUeEc=" + idUeEc +
                ", note=" + note +
                ", NomMatiere='" + NomMatiere + '\'' +
                '}';
    }
}
