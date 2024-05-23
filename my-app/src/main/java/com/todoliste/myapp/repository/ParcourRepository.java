package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.ParcourModel;
import com.todoliste.myapp.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcourRepository extends JpaRepository<ParcourModel, Integer> {
   // ParcourModel findByNomParcoursAndAbreviationParcour(String nomParcours, String abreviationParcours);

    ParcourModel findByNomParcoursAndAbreviationparcour(String nomParcours, String abreviationParcours);
}
