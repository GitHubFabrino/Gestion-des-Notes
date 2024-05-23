package com.todoliste.myapp.service;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.repository.MentionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentionService {
    @Autowired
    MentionRepository mentionRepository;

    public void creer(MentionModel mention) {
        mention.setNom_Mention(mention.getNom_Mention());
        mention.setAbreviation_Mention(mention.getAbreviation_Mention());
        this.mentionRepository.save(mention);
    }

    public List<MentionModel> afficherTous() {
        return this.mentionRepository.findAll();
    }

    public MentionModel afficherOne(int id_mention) {
        Optional<MentionModel> mentionExist = this.mentionRepository.findById(id_mention);
        if (mentionExist.isPresent()){
            return mentionExist.get();
        }
        return null;
    }

    public void modifier(int id_mention, MentionModel mention) {
        MentionModel mentionDansBd = this.afficherOne(id_mention);

        if (mentionDansBd.getId_Mention() == id_mention){

            mentionDansBd.setNom_Mention(mention.getNom_Mention());
            mentionDansBd.setAbreviation_Mention(mention.getAbreviation_Mention());
            this.mentionRepository.save(mentionDansBd);
        }
    }

    public void supprimer(int id_mention) {
        this.mentionRepository.deleteById(id_mention);
    }
}
