package com.todoliste.myapp.models;

import javax.persistence.*;

@Entity
@Table(name = "df_parcours")
public class DefinitionParcours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_DP;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_DM")
    private DefinitionMentionModel idDM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Parcour")
    private  ParcourModel idParcour;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Niveau")
    private NiveauModel idNiveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Semestre")
    private SemestreModel idSemestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_AU")
    private AnneeUniversitaireModel idAU;

    public DefinitionParcours() {
    }

    public DefinitionParcours(int id_dfParcour, DefinitionMentionModel idDM, ParcourModel idParcour, NiveauModel idNiveau, SemestreModel idSemestre, AnneeUniversitaireModel idAU) {
        this.id_DP = id_dfParcour;
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
    }

    public DefinitionParcours(DefinitionMentionModel idDM, ParcourModel idParcour, NiveauModel idNiveau, SemestreModel idSemestre, AnneeUniversitaireModel idAU) {
        this.idDM = idDM;
        this.idParcour = idParcour;
        this.idNiveau = idNiveau;
        this.idSemestre = idSemestre;
        this.idAU = idAU;
    }

    public int getId_dfParcour() {
        return id_DP;
    }

    public void setId_dfParcour(int id_dfParcour) {
        this.id_DP = id_dfParcour;
    }

    public DefinitionMentionModel getIdDM() {
        return idDM;
    }

    public void setIdDM(DefinitionMentionModel idDM) {
        this.idDM = idDM;
    }

    public ParcourModel getIdParcour() {
        return idParcour;
    }

    public void setIdParcour(ParcourModel idParcour) {
        this.idParcour = idParcour;
    }

    public NiveauModel getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(NiveauModel idNiveau) {
        this.idNiveau = idNiveau;
    }

    public SemestreModel getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(SemestreModel idSemestre) {
        this.idSemestre = idSemestre;
    }

    public AnneeUniversitaireModel getIdAU() {
        return idAU;
    }

    public void setIdAU(AnneeUniversitaireModel idAU) {
        this.idAU = idAU;
    }
}
