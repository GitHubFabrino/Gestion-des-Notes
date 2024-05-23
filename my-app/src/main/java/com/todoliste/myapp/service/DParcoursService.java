package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.DParcoursDto;
import com.todoliste.myapp.models.*;
import com.todoliste.myapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DParcoursService {

    @Autowired
    DParcoursReository dParcoursReository;

    @Autowired
    ParcourRepository parcourRepository;

    @Autowired
    AnneeUniversitaireRepository anneeUniversitaireRepository;

    @Autowired
    SemestreRepository semestreRepository;

    @Autowired
    NiveauRepository niveauRepository;

    @Autowired
    DMRepository dmRepository;


    public void creer(int idAu, DParcoursDto dParcoursDto) {

        System.out.println("idAu  : " + idAu);
        System.out.println(" id DP : " + dParcoursDto.getIddfParcour());
        System.out.println(" id DM : " + dParcoursDto.getIdDM());
        System.out.println(" id parcour : " + dParcoursDto.getIdParcour());
        System.out.println(" niveau : " + dParcoursDto.getIdNiveau());
        System.out.println(" id semestre : " + dParcoursDto.getIdSemestre());
        System.out.println(" id Au : " + dParcoursDto.getIdAU());
        System.out.println(" Nom parcour : " + dParcoursDto.getNomParcours());
        System.out.println(" Abreviation : " + dParcoursDto.getAbreviationParcours());

        AnneeUniversitaireModel AU = anneeUniversitaireRepository.findById(dParcoursDto.getIdAU()).orElseThrow();
        SemestreModel semestre = semestreRepository.findById(dParcoursDto.getIdSemestre()).orElseThrow();
        NiveauModel niveau = niveauRepository.findById(dParcoursDto.getIdNiveau()).orElseThrow();
        DefinitionMentionModel dm = dmRepository.findById(dParcoursDto.getIdDM()).orElseThrow();


        DefinitionParcours newDParcours = new DefinitionParcours();
        newDParcours.setIdAU(AU);
        newDParcours.setIdDM(dm);
        newDParcours.setIdNiveau(niveau);
        newDParcours.setIdSemestre(semestre);

        ParcourModel parcoursExist = parcourRepository.findByNomParcoursAndAbreviationparcour(dParcoursDto.getNomParcours(),dParcoursDto.getAbreviationParcours());

        if (parcoursExist == null){
            ParcourModel parcourNew = new ParcourModel();
            parcourNew.setNomParcours(dParcoursDto.getNomParcours());
            parcourNew.setAbreviationParcour(dParcoursDto.getAbreviationParcours());
            parcourRepository.save(parcourNew);
            System.out.println(" Nouveau parcour id parcour : " + parcourNew.getId_Parcour());
            newDParcours.setIdParcour(parcourNew);

        }else {
            System.out.println("  parcour misy : ");
            newDParcours.setIdParcour(parcoursExist);
        }
        dParcoursReository.save(newDParcours);
        System.out.println(" Nouveau DParcours : " + newDParcours.getId_dfParcour());


    }

    public List<DParcoursDto> afficherTous(int idAu) {

        ArrayList<DefinitionParcours> ObjetDParcours = this.dParcoursReository.findAllByIdAU(anneeUniversitaireRepository.findById(idAu));
        ArrayList<DParcoursDto> dParcoursDtos = new ArrayList<>();

        for (DefinitionParcours dp : ObjetDParcours){

            try{
                dParcoursDtos.add(new DParcoursDto(
                        dp.getId_dfParcour(),
                        dp.getIdDM().getId_DM(),
                        dp.getIdParcour().getId_Parcour(),
                        dp.getIdNiveau().getId_Niveau(),
                        dp.getIdSemestre().getId_Semestre(),
                        dp.getIdAU().getId_AU(),
                        dp.getIdParcour().getNomParcours(),
                        dp.getIdParcour().getAbreviationParcour(),
                        dp.getIdNiveau().getNom_niveau(),
                        dp.getIdDM().getId_Mention().getAbreviation_Mention(),
                        dp.getIdSemestre().getNom_semestre()
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Collections.reverse(dParcoursDtos);
        return dParcoursDtos;


    }

    public void supprimer(int idDP) {
        this.dParcoursReository.deleteById(idDP);
    }

    public void modifier(int iddp, DParcoursDto dParcoursDto) {
        System.out.println("iddp  : " + iddp);
        System.out.println(" id Au : " + dParcoursDto.getIdAU());
        System.out.println(" id DP : " + dParcoursDto.getIddfParcour());
        System.out.println(" id parcour : " + dParcoursDto.getIdParcour());

        System.out.println(" id DM : " + dParcoursDto.getIdDM());
        System.out.println(" niveau : " + dParcoursDto.getIdNiveau());
        System.out.println(" id semestre : " + dParcoursDto.getIdSemestre());
        System.out.println(" Nom parcour : " + dParcoursDto.getNomParcours());
        System.out.println(" Abreviation : " + dParcoursDto.getAbreviationParcours());


        SemestreModel semestre = semestreRepository.findById(dParcoursDto.getIdSemestre()).orElseThrow();
        NiveauModel niveau = niveauRepository.findById(dParcoursDto.getIdNiveau()).orElseThrow();
        DefinitionMentionModel dm = dmRepository.findById(dParcoursDto.getIdDM()).orElseThrow();

        DefinitionParcours dpExist = dParcoursReository.findById(iddp).orElse(null);
        if (dpExist.getId_dfParcour() == dParcoursDto.getIddfParcour()){
            dpExist.setIdDM(dm);
            dpExist.setIdNiveau(niveau);
            dpExist.setIdSemestre(semestre);
            dpExist.getIdParcour().setNomParcours(dParcoursDto.getNomParcours());
            dpExist.getIdParcour().setAbreviationParcour(dParcoursDto.getAbreviationParcours());

            dParcoursReository.save(dpExist);
            System.out.println("Bien modifier ");
        }
    }

    public List<DParcoursDto> afficherTousParMention(int idAu, int idDm, int idNiv) {

        ArrayList<DefinitionParcours> ObjetDParcours = this.dParcoursReository.findAllByIdAUAndIdDMAndIdNiveau(anneeUniversitaireRepository.findById(idAu) , dmRepository.findById(idDm) , niveauRepository.findById(idNiv));
        ArrayList<DParcoursDto> dParcoursDtos = new ArrayList<>();
        for (DefinitionParcours dp : ObjetDParcours){

            try{
                dParcoursDtos.add(new DParcoursDto(
                        dp.getIdDM().getId_DM(),
                        dp.getId_dfParcour(),
                        dp.getIdParcour().getAbreviationParcour(),
                        dp.getIdSemestre().getNom_semestre(),
                        dp.getIdSemestre().getId_Semestre()
                ));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return dParcoursDtos;
    }










}
