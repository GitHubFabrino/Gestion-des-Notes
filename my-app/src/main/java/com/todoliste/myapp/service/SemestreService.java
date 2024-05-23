package com.todoliste.myapp.service;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.SemestreModel;
import com.todoliste.myapp.repository.SemestreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    SemestreRepository semestreRepository;


    public void creer(SemestreModel semestre) {
        semestre.setNom_semestre(semestre.getNom_semestre());
        this.semestreRepository.save(semestre);
    }

    public List<SemestreModel> afficherTous() {
        return  this.semestreRepository.findAll();
    }

    public SemestreModel afficherOne(int id_semestre) {
        Optional<SemestreModel> semestreExist = this.semestreRepository.findById(id_semestre);
        if (semestreExist.isPresent()){
            return semestreExist.get();
        }
        return null;
    }

    public void modifier(int id_semestre, SemestreModel semestre) {
        SemestreModel semestreDansDb = this.afficherOne(id_semestre);

        if (semestreDansDb.getId_Semestre() == id_semestre){

            semestreDansDb.setNom_semestre(semestre.getNom_semestre());
            this.semestreRepository.save(semestreDansDb);
        }
    }

    public void supprimer(int id_semestre) {
        this.semestreRepository.deleteById(id_semestre);
    }
}
