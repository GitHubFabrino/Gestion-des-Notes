package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "etudiant")
public class EtudiantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;

    @Column(name = "numeromatricule")
    private String numeromatricule ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Personne")
    private Personne idPersonne;

    public EtudiantModel() {
    }

    public EtudiantModel(int id_Etudiant, String numeromatricule, Personne idPersonne) {
        this.idEtudiant = id_Etudiant;
        this.numeromatricule = numeromatricule;
        this.idPersonne = idPersonne;
    }

    public EtudiantModel(String numeromatricule, Personne idPersonne) {
        this.numeromatricule = numeromatricule;
        this.idPersonne = idPersonne;
    }

    public int getId_Etudiant() {
        return idEtudiant;
    }

    public void setId_Etudiant(int id_Etudiant) {
        this.idEtudiant = id_Etudiant;
    }

    public String getNumeromatricule() {
        return numeromatricule;
    }

    public void setNumeromatricule(String numeromatricule) {
        this.numeromatricule = numeromatricule;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }
}
