package com.todoliste.myapp.service;

import com.todoliste.myapp.dto.DMDto;
import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.DefinitionMentionModel;
import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.repository.AnneeUniversitaireRepository;
import com.todoliste.myapp.repository.DMRepository;
import com.todoliste.myapp.repository.MentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DMService {

    @Autowired
    DMRepository dmRepository;

    @Autowired
    MentionRepository mentionRepository;

    @Autowired
    AnneeUniversitaireRepository anneeUniversitaireRepository;

    public String creer(int idAu, DMDto dMModel) {
/*        System.out.println("idAu  : " + idAu);
        System.out.println(" id mention : " + dMModel.getId_Mention());
        System.out.println(" id Au : " + dMModel.getId_AU());
        System.out.println(" Nom Mention : " + dMModel.getNom_Mention());
        System.out.println(" Abreviation : " + dMModel.getAbreviation_Mention());
*/
        AnneeUniversitaireModel auExist  = anneeUniversitaireRepository.findById(dMModel.getId_AU()).orElse(null);
        if (auExist == null){
            return "année universitaire n'existe pas " ;
        }else {
            DefinitionMentionModel newDM = new DefinitionMentionModel();
            newDM.setId_AU(auExist);
            MentionModel mentionExist = mentionRepository.findByNomMentionAndAbreviationMention(dMModel.getNom_Mention(),dMModel.getAbreviation_Mention()).orElse(null);
            MentionModel newMention  = new MentionModel();
            if (mentionExist == null ){

                newMention.setNom_Mention(dMModel.getNom_Mention());
                newMention.setAbreviation_Mention(dMModel.getAbreviation_Mention());
                mentionRepository.save(newMention);
              //  System.out.println("Mention creer  : " + newMention.getId_Mention());
                newDM.setId_Mention(newMention);

            }else {
              //  System.out.println("  misy : " );
                newDM.setId_Mention(mentionExist);
            }

            dmRepository.save(newDM);
         //   System.out.println("DM creer  : " + newDM.getId_DM());


        }


        return null;
    }

    public ArrayList<DMDto> afficherTous(int idAu) {

        ArrayList<DefinitionMentionModel> ObjetDMention = this.dmRepository.findAllByIdAU(anneeUniversitaireRepository.findById(idAu).orElseThrow());

        ArrayList<DMDto> DMDtos = new ArrayList<>();

        for (DefinitionMentionModel DMM : ObjetDMention){
            try{
                DMDtos.add(new DMDto(
                        DMM.getId_DM(),
                        DMM.getId_Mention().getId_Mention(),
                        DMM.getId_AU().getId_AU(),
                        DMM.getId_Mention().getNom_Mention(),
                        DMM.getId_Mention().getAbreviation_Mention()

                ));
            }
            catch (Exception e ){}
        }
        Collections.reverse(DMDtos);
        return DMDtos;
    }

    public void supprimer(int idDM) {
        this.dmRepository.deleteById(idDM);
    }

    public void modifier(int iddm, DMDto dmDto) {
       /* System.out.println("iddm :" + iddm);
        System.out.println("Iddm :" + dmDto.getId_DM());
        System.out.println("IdAu :" + dmDto.getId_AU());
        System.out.println("IdMention :" + dmDto.getId_Mention());
        System.out.println("Nom Mention :" + dmDto.getNom_Mention());
        System.out.println("Acro :" + dmDto.getAbreviation_Mention());*/

        DefinitionMentionModel dmExist = dmRepository.findById(dmDto.getId_DM()).orElse(null);
        if(dmExist.getId_DM() == dmDto.getId_DM()){
            MentionModel mentionModifier = mentionRepository.findById(dmDto.getId_Mention()).orElse(null);
            mentionModifier.setNom_Mention(dmDto.getNom_Mention());
            mentionModifier.setAbreviation_Mention(dmDto.getAbreviation_Mention());
            mentionRepository.save(mentionModifier);
            System.out.println("Bien modifier ");

        }

    }
}
