package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "cursus")
public class CursusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Cursus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Etudiant")
    private EtudiantModel idEtudiant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_DP")
    private DefinitionParcours idDP;

    public CursusModel() {
    }

    public CursusModel(int id_Cursus, EtudiantModel idEtudiant, DefinitionParcours idDP) {
        this.id_Cursus = id_Cursus;
        this.idEtudiant = idEtudiant;
        this.idDP = idDP;
    }

    public CursusModel(EtudiantModel idEtudiant, DefinitionParcours idDP) {
        this.idEtudiant = idEtudiant;
        this.idDP = idDP;
    }

    public int getId_Cursus() {
        return id_Cursus;
    }

    public void setId_Cursus(int id_Cursus) {
        this.id_Cursus = id_Cursus;
    }

    public EtudiantModel getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(EtudiantModel idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public DefinitionParcours getIdDP() {
        return idDP;
    }

    public void setIdDP(DefinitionParcours idDP) {
        this.idDP = idDP;
    }
}
