package com.todoliste.myapp.dto;

import java.util.ArrayList;

public class ReleverDTO {

    private Integer id_DP1;
    private Integer idCursus;
    private  Integer idEtudiant;
    private String nom;
    private String prenom;
    private String numeromatricule;
    ArrayList<ReleverNoteDTO> releverNoteDTOS;

    ArrayList<ListeUeDTO> listeUeDTOS;


    public ReleverDTO() {
    }

    public ReleverDTO(Integer id_DP1, Integer idCursus, Integer idEtudiant, String nom, String prenom, String numeromatricule, ArrayList<ListeUeDTO> listeUeDTOS) {
        this.id_DP1 = id_DP1;
        this.idCursus = idCursus;
        this.idEtudiant = idEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.numeromatricule = numeromatricule;
        this.listeUeDTOS = listeUeDTOS;
    }

    public ArrayList<ListeUeDTO> getListeUeDTOS() {
        return listeUeDTOS;
    }

    public void setListeUeDTOS(ArrayList<ListeUeDTO> listeUeDTOS) {
        this.listeUeDTOS = listeUeDTOS;
    }

    public ReleverDTO(Integer id_DP1, Integer idEtudiant, ArrayList<ReleverNoteDTO> releverNoteDTOS) {
        this.id_DP1 = id_DP1;
        this.idEtudiant = idEtudiant;
        this.releverNoteDTOS = releverNoteDTOS;
    }

    public Integer getId_DP1() {
        return id_DP1;
    }

    public void setId_DP1(Integer id_DP1) {
        this.id_DP1 = id_DP1;
    }

    public Integer getIdCursus() {
        return idCursus;
    }

    public void setIdCursus(Integer idCursus) {
        this.idCursus = idCursus;
    }


    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
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

    public String getNumeromatricule() {
        return numeromatricule;
    }

    public void setNumeromatricule(String numeromatricule) {
        this.numeromatricule = numeromatricule;
    }

    public ArrayList<ReleverNoteDTO> getReleverNoteDTOS() {
        return releverNoteDTOS;
    }

    public void setReleverNoteDTOS(ArrayList<ReleverNoteDTO> releverNoteDTOS) {
        this.releverNoteDTOS = releverNoteDTOS;
    }
}
