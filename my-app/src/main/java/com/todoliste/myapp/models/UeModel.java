package com.todoliste.myapp.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ue")
public class UeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUe;

    @Column(name = "nom_Ue")
    private String nomUe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_DP")
    private DefinitionParcours idDP;

    @Column(name = "creditue")
    private BigDecimal creditUe;

    public UeModel() {
    }

    public UeModel(int idUe, String nomUe, DefinitionParcours idParcours, BigDecimal creditUe) {
        this.idUe = idUe;
        this.nomUe = nomUe;
        this.idDP = idParcours;
        this.creditUe = creditUe;
    }

    public UeModel(String nomUe, DefinitionParcours idParcours, BigDecimal creditUe) {
        this.nomUe = nomUe;
        this.idDP = idParcours;
        this.creditUe = creditUe;
    }

    public int getIdUe() {
        return idUe;
    }

    public void setIdUe(int idUe) {
        this.idUe = idUe;
    }

    public String getNomUe() {
        return nomUe;
    }

    public void setNomUe(String nomUe) {
        this.nomUe = nomUe;
    }

    public DefinitionParcours getIdParcours() {
        return idDP;
    }

    public void setIdParcours(DefinitionParcours idParcours) {
        this.idDP = idParcours;
    }

    public BigDecimal getCreditUe() {
        return creditUe;
    }

    public void setCreditUe(BigDecimal creditUe) {
        this.creditUe = creditUe;
    }
}
