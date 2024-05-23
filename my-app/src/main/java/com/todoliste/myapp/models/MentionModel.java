package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "mention")
public class MentionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Mention;

    @Column(name = "nom_Mention")
    private String nomMention;

    @Column(name = "abreviation_Mention")
    private  String abreviationMention;

    public MentionModel() {
    }

    public MentionModel(int id_Mention, String nom_Mention, String abreviation_Mention) {
        this.id_Mention = id_Mention;
        this.nomMention = nom_Mention;
        this.abreviationMention = abreviation_Mention;
    }

    public MentionModel(String nom_Mention, String abreviation_Mention) {
        this.nomMention = nom_Mention;
        this.abreviationMention = abreviation_Mention;
    }

    public int getId_Mention() {
        return id_Mention;
    }

    public void setId_Mention(int id_Mention) {
        this.id_Mention = id_Mention;
    }

    public String getNom_Mention() {
        return nomMention;
    }

    public void setNom_Mention(String nom_Mention) {
        this.nomMention = nom_Mention;
    }

    public String getAbreviation_Mention() {
        return abreviationMention;
    }

    public void setAbreviation_Mention(String abreviation_Mention) {
        this.abreviationMention = abreviation_Mention;
    }
}
