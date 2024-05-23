package com.todoliste.myapp.dto;

public class DParcoursDto {

    private  Integer iddfParcour;
    private Integer idDM;
    private Integer idParcour;
    private Integer idNiveau;
    private Integer idSemestre;
    private Integer idAU;

    private String nomParcours;
    private String abreviationParcours;

    private String niveau;
    private String mention;

    private String semestre;

    public DParcoursDto() {
    }

    public DParcoursDto(Integer iddfParcour, Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, Integer idAU, String nomParcours, String abreviationParcours) {
        this.iddfParcour = iddfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
    }

    public DParcoursDto(Integer iddfParcour, Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, String nomParcours, String abreviationParcours) {
        this.iddfParcour = iddfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
    }

    public DParcoursDto(Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, String nomParcours, String abreviationParcours) {
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
    }

    public DParcoursDto(Integer iddfParcour, Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, Integer idAU, String nomParcours, String abreviationParcours, String niveau) {
        this.iddfParcour = iddfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
        this.niveau = niveau;
    }

    public DParcoursDto(Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, Integer idAU, String nomParcours, String abreviationParcours, String niveau) {
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
        this.niveau = niveau;
    }

    public DParcoursDto(Integer iddfParcour, Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, Integer idAU, String nomParcours, String abreviationParcours, String niveau, String mention) {
        this.iddfParcour = iddfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
        this.niveau = niveau;
        this.mention = mention;
    }

    public DParcoursDto(Integer iddfParcour, Integer idDM, Integer idParcour, Integer idNiveau, Integer idSemestre, Integer idAU, String nomParcours, String abreviationParcours, String niveau, String mention, String semestre) {
        this.iddfParcour = iddfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
        this.nomParcours = nomParcours;
        this.abreviationParcours = abreviationParcours;
        this.niveau = niveau;
        this.mention = mention;
        this.semestre = semestre;
    }

    public DParcoursDto(int idDM , int id_dfParcour, String abreviationParcour, String semestre , int idSemestre) {
        this.idDM = idDM;
        this.iddfParcour = id_dfParcour;
        this.abreviationParcours = abreviationParcour;
        this.semestre = semestre;
        this.idSemestre = idSemestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public Integer getIddfParcour() {
        return iddfParcour;
    }

    public void setIddfParcour(Integer iddfParcour) {
        this.iddfParcour = iddfParcour;
    }

    public Integer getIdDM() {
        return idDM;
    }

    public void setIdDM(Integer idDM) {
        this.idDM = idDM;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public Integer getIdParcour() {
        return idParcour;
    }

    public void setIdParcour(Integer idParcour) {
        this.idParcour = idParcour;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getIdAU() {
        return idAU;
    }

    public void setIdAU(Integer idAU) {
        this.idAU = idAU;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public String getAbreviationParcours() {
        return abreviationParcours;
    }

    public void setAbreviationParcours(String abreviationParcours) {
        this.abreviationParcours = abreviationParcours;
    }
}
