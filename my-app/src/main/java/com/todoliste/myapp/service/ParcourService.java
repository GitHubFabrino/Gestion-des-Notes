package com.todoliste.myapp.service;

import com.todoliste.myapp.models.ParcourModel;
import com.todoliste.myapp.repository.ParcourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcourService {
    @Autowired
    ParcourRepository parcourRepository;

    public void creer(ParcourModel parcour) {

        parcour.setNomParcours(parcour.getNomParcours());
        this.parcourRepository.save(parcour);
    }

    public List<ParcourModel> afficherTous() {

        return this.parcourRepository.findAll();
    }

    public ParcourModel afficherOne(int id_parcours) {
        Optional<ParcourModel> parcourExist = this.parcourRepository.findById(id_parcours);

        if (parcourExist.isPresent()){
            return parcourExist.get();
        }

        return null;
    }

    public void modifier(int id_parcours, ParcourModel parcour) {
        ParcourModel parcourDansDb = this.afficherOne(id_parcours);
        if (parcourDansDb.getId_Parcour() == id_parcours){

            parcourDansDb.setNomParcours(parcour.getNomParcours());
            this.parcourRepository.save(parcourDansDb);
        }
    }

    public void supprimer(int id_parcours) {
        this.parcourRepository.deleteById(id_parcours);
    }
}
