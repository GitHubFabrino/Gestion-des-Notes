package com.todoliste.myapp.dto;

public class DMDto {
    private Integer id_DM;
    private Integer id_Mention;
    private Integer id_AU;

    private String nom_Mention;

    private String abreviation_Mention;

    public DMDto() {
    }

    public DMDto(Integer id_DM, Integer id_Mention, Integer id_AU, String nom_Mention, String abreviation_Mention) {
        this.id_DM = id_DM;
        this.id_Mention = id_Mention;
        this.id_AU = id_AU;
        this.nom_Mention = nom_Mention;
        this.abreviation_Mention = abreviation_Mention;
    }

    public DMDto(Integer id_Mention, Integer id_AU, String nom_Mention, String abreviation_Mention) {
        this.id_Mention = id_Mention;
        this.id_AU = id_AU;
        this.nom_Mention = nom_Mention;
        this.abreviation_Mention = abreviation_Mention;
    }

    public DMDto(Integer id_AU, String nom_Mention, String abreviation_Mention) {
        this.id_AU = id_AU;
        this.nom_Mention = nom_Mention;
        this.abreviation_Mention = abreviation_Mention;
    }


    public Integer getId_DM() {
        return id_DM;
    }

    public void setId_DM(Integer id_DM) {
        this.id_DM = id_DM;
    }

    public Integer getId_Mention() {
        return id_Mention;
    }

    public void setId_Mention(Integer id_Mention) {
        this.id_Mention = id_Mention;
    }

    public Integer getId_AU() {
        return id_AU;
    }

    public void setId_AU(Integer id_AU) {
        this.id_AU = id_AU;
    }

    public String getNom_Mention() {
        return nom_Mention;
    }

    public void setNom_Mention(String nom_Mention) {
        this.nom_Mention = nom_Mention;
    }

    public String getAbreviation_Mention() {
        return abreviation_Mention;
    }

    public void setAbreviation_Mention(String abreviation_Mention) {
        this.abreviation_Mention = abreviation_Mention;
    }
}
