package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "niveau")
public class NiveauModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_Niveau;
    @Column(name = "nom_niveau")
    private String nom_niveau;

    public NiveauModel() {
    }

    public NiveauModel(int id_Niveau, String nom_niveau) {
        this.id_Niveau = id_Niveau;
        this.nom_niveau = nom_niveau;
    }

    public NiveauModel(String nom_niveau) {
        this.nom_niveau = nom_niveau;
    }

    public int getId_Niveau() {
        return id_Niveau;
    }

    public void setId_Niveau(int id_Niveau) {
        this.id_Niveau = id_Niveau;
    }

    public String getNom_niveau() {
        return nom_niveau;
    }

    public void setNom_niveau(String nom_niveau) {
        this.nom_niveau = nom_niveau;
    }
}
