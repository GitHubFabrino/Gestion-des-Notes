package com.todoliste.myapp.dto;

public class CursusDTO {

    private Integer id_DP1;
    private Integer id_DP2;
    private String nom;
    private String prenom;
    private String numeromatricule;

    private Integer idCursus;
    private  Integer idEtudiant;

    public CursusDTO() {
    }

    public CursusDTO(Integer id_DP1, Integer id_DP2, String nom, String prenom, String numeromatricule) {
        this.id_DP1 = id_DP1;
        this.id_DP2 = id_DP2;
        this.nom = nom;
        this.prenom = prenom;
        this.numeromatricule = numeromatricule;
    }

    public CursusDTO(Integer id_DP1, Integer id_DP2, String nom, String prenom, String numeromatricule, Integer idCursus, Integer idEtudiant) {
        this.id_DP1 = id_DP1;
        this.id_DP2 = id_DP2;
        this.nom = nom;
        this.prenom = prenom;
        this.numeromatricule = numeromatricule;
        this.idCursus = idCursus;
        this.idEtudiant = idEtudiant;
    }

    public CursusDTO(String nom, String prenom, String numeromatricule) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeromatricule = numeromatricule;
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

    public Integer getId_DP1() {
        return id_DP1;
    }

    public void setId_DP1(Integer id_DP1) {
        this.id_DP1 = id_DP1;
    }

    public Integer getId_DP2() {
        return id_DP2;
    }

    public void setId_DP2(Integer id_DP2) {
        this.id_DP2 = id_DP2;
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
}
