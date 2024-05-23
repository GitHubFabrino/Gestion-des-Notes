package com.todoliste.myapp.service;

import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.Personne;
import com.todoliste.myapp.repository.AnneeUniversitaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnneeUniversitaireService {

    @Autowired
    AnneeUniversitaireRepository anneeUniversitaireRepository;
    public void creer(AnneeUniversitaireModel anneeUniversitaire) {
        anneeUniversitaire.setNom_AU(anneeUniversitaire.getNom_AU());
        anneeUniversitaire.setSession(anneeUniversitaire.getSession());
        this.anneeUniversitaireRepository.save(anneeUniversitaire);
    }

    public List<AnneeUniversitaireModel> afficherTous() {
        return this.anneeUniversitaireRepository.findAll();
    }

    public AnneeUniversitaireModel afficherOne(int id_au) {
        Optional<AnneeUniversitaireModel> oneAU = this.anneeUniversitaireRepository.findById(id_au);
        if (oneAU.isPresent()){
            return  oneAU.get();
        }
        return null;
    }

    public void modifier_au(int id_au, AnneeUniversitaireModel anneeUniversitaire) {
        AnneeUniversitaireModel auExist = this.afficherOne(id_au);
        if (auExist.getId_AU()== id_au){
            auExist.setNom_AU(anneeUniversitaire.getNom_AU());
            auExist.setSession(anneeUniversitaire.getSession());
            this.anneeUniversitaireRepository.save(auExist);
        }
    }

    public void supprimer_Au(int id_au) { this.anneeUniversitaireRepository.deleteById(id_au);
    }
}
