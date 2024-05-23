package com.todoliste.myapp.models;


import javax.persistence.*;

@Entity
@Table(name = "personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Personne;

    @Column(name = "nom")
    private String nom ;

    @Column(name = "prenom")
    private String prenom ;

    public Personne() {
    }

    public Personne(int id_Personne, String nom, String prenom) {
        this.id_Personne = id_Personne;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId_Personne() {
        return id_Personne;
    }

    public void setId_Personne(int id_Personne) {
        this.id_Personne = id_Personne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id_Personne=" + id_Personne +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
