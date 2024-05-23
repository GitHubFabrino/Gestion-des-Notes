package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "ec")
public class EcModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEc;

    @Column(name = "matiere")
    private  String matiere;

    public EcModel() {
    }

    public EcModel(int idEc, String matiere) {
        this.idEc = idEc;
        this.matiere = matiere;
    }

    public EcModel(String matiere) {
        this.matiere = matiere;
    }

    public int getIdEc() {
        return idEc;
    }

    public void setIdEc(int idEc) {
        this.idEc = idEc;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
