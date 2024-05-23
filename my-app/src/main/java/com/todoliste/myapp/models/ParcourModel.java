package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "parcours")
public class ParcourModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Parcour;

    @Column(name = "nom_Parcours")
    private String nomParcours;

    @Column(name = "abreviationparcour")
    private String abreviationparcour;

    public ParcourModel() {
    }

    public ParcourModel(int id_Parcour, String nomParcours, String abreviationParcour) {
        this.id_Parcour = id_Parcour;
        this.nomParcours = nomParcours;
        this.abreviationparcour = abreviationParcour;
    }

    public ParcourModel(String nomParcours, String abreviationParcour) {
        this.nomParcours = nomParcours;
        this.abreviationparcour = abreviationParcour;
    }

    public int getId_Parcour() {
        return id_Parcour;
    }

    public void setId_Parcour(int id_Parcour) {
        this.id_Parcour = id_Parcour;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public String getAbreviationParcour() {
        return abreviationparcour;
    }

    public void setAbreviationParcour(String abreviationParcour) {
        this.abreviationparcour = abreviationParcour;
    }
}
