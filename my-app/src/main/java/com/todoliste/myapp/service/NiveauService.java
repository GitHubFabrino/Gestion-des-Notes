package com.todoliste.myapp.service;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.NiveauModel;
import com.todoliste.myapp.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauService {

    @Autowired
    NiveauRepository niveauRepository;

    public void creer(NiveauModel niveau) {
        niveau.setNom_niveau(niveau.getNom_niveau());
        this.niveauRepository.save(niveau);
    }

    public List<NiveauModel> afficherTous() {
        return this.niveauRepository.findAll();
    }

    public NiveauModel afficherOne(int id_niveau) {
        Optional<NiveauModel> niveauExist = this.niveauRepository.findById(id_niveau);
        if (niveauExist.isPresent()){
            return niveauExist.get();
        }
        return null;
    }

    public void modifier(int id_niveau, NiveauModel niveau) {
        NiveauModel niveauDansBd = this.afficherOne(id_niveau);

        if (niveauDansBd.getId_Niveau() == id_niveau){

            niveauDansBd.setNom_niveau(niveau.getNom_niveau());
            this.niveauRepository.save(niveauDansBd);
        }
    }

    public void supprimer(int id_niveau) {
        this.niveauRepository.deleteById(id_niveau);
    }
}
