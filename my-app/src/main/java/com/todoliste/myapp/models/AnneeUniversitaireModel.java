package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "au")
public class AnneeUniversitaireModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_AU;

    @Column(name = "nom_AU")
    private  String nom_AU;

    @Column(name = "session")
    private  String session;

    public AnneeUniversitaireModel() {
    }

    public AnneeUniversitaireModel(int id_AU, String nom_AU, String session) {
        this.id_AU = id_AU;
        this.nom_AU = nom_AU;
        this.session = session;
    }

    public AnneeUniversitaireModel(String nom_AU, String session) {
        this.nom_AU = nom_AU;
        this.session = session;
    }

    public int getId_AU() {
        return id_AU;
    }

    public void setId_AU(int id_AU) {
        this.id_AU = id_AU;
    }

    public String getNom_AU() {
        return nom_AU;
    }

    public void setNom_AU(String nom_AU) {
        this.nom_AU = nom_AU;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
