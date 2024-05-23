package com.todoliste.myapp.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "relever")
public class ReleveeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Relever;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cursus")
    private CursusModel idCursus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ue_ec")
    private UeEcModel idUeEc;

    @Column(name = "note")
    private BigDecimal note;

    public ReleveeModel() {
    }

    public ReleveeModel(CursusModel idCursus, UeEcModel idUeEc, BigDecimal note) {
        this.idCursus = idCursus;
        this.idUeEc = idUeEc;
        this.note = note;
    }

    public ReleveeModel(int id_Relever, CursusModel idCursus, UeEcModel idUeEc, BigDecimal note) {
        this.id_Relever = id_Relever;
        this.idCursus = idCursus;
        this.idUeEc = idUeEc;
        this.note = note;
    }

    public int getId_Relever() {
        return id_Relever;
    }

    public void setId_Relever(int id_Relever) {
        this.id_Relever = id_Relever;
    }

    public CursusModel getIdCursus() {
        return idCursus;
    }

    public void setIdCursus(CursusModel idCursus) {
        this.idCursus = idCursus;
    }

    public UeEcModel getIdUeEc() {
        return idUeEc;
    }

    public void setIdUeEc(UeEcModel idUeEc) {
        this.idUeEc = idUeEc;
    }

    public BigDecimal getNote() {
        return note;
    }

    public void setNote(BigDecimal note) {
        this.note = note;
    }
}
