package com.todoliste.myapp.service;

import com.todoliste.myapp.models.Personne;
import com.todoliste.myapp.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    PersonneRepository personneRepository;


    public void creer(Personne personne) {
        personne.setNom(personne.getNom());
        personne.setPrenom(personne.getPrenom());
        this.personneRepository.save(personne);
    }

    public List<Personne> afficherTous() {
    return this.personneRepository.findAll();
    }

    public Personne afficherOne(int id_personne) {
        Optional<Personne> onePersonne = this.personneRepository.findById(id_personne);
        if (onePersonne.isPresent()){
            return  onePersonne.get();
        }
        return null;
    }

    public void modifier_personne(int id_personne, Personne personne) {
        Personne personneExist = this.afficherOne(id_personne);

        if (personneExist.getId_Personne() == id_personne){
            personneExist.setNom(personne.getNom());
            personneExist.setPrenom(personne.getPrenom());
            this.personneRepository.save(personneExist);
        }
    }

    public void supprimer_personne(int id_personne) {
        this.personneRepository.deleteById(id_personne);
    }
}
