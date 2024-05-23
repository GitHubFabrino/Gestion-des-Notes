package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "df_Mention")
public class DefinitionMentionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_DM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Mention")
    private MentionModel id_Mention;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_AU")
    private AnneeUniversitaireModel idAU;

    public DefinitionMentionModel() {
    }

    public DefinitionMentionModel(int id_DM, MentionModel id_Mention, AnneeUniversitaireModel id_AU) {
        this.id_DM = id_DM;
        this.id_Mention = id_Mention;
        this.idAU = id_AU;
    }

    public DefinitionMentionModel(MentionModel id_Mention, AnneeUniversitaireModel id_AU) {
        this.id_Mention = id_Mention;
        this.idAU = id_AU;
    }

    public int getId_DM() {
        return id_DM;
    }

    public void setId_DM(int id_DM) {
        this.id_DM = id_DM;
    }

    public MentionModel getId_Mention() {
        return id_Mention;
    }

    public void setId_Mention(MentionModel id_Mention) {
        this.id_Mention = id_Mention;
    }

    public AnneeUniversitaireModel getId_AU() {
        return idAU;
    }

    public void setId_AU(AnneeUniversitaireModel id_AU) {
        this.idAU = id_AU;
    }
}
