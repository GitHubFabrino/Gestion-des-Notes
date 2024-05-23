package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "semestre")
public class SemestreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Semestre;

    @Column(name = "nom_semestre")
    private String nom_semestre;

    public SemestreModel() {
    }

    public SemestreModel(int id_Semestre, String nom_semestre) {
        this.id_Semestre = id_Semestre;
        this.nom_semestre = nom_semestre;
    }

    public SemestreModel(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }

    public int getId_Semestre() {
        return id_Semestre;
    }

    public void setId_Semestre(int id_Semestre) {
        this.id_Semestre = id_Semestre;
    }

    public String getNom_semestre() {
        return nom_semestre;
    }

    public void setNom_semestre(String nom_semestre) {
        this.nom_semestre = nom_semestre;
    }
}
