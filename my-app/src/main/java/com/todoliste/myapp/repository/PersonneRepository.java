package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository <Personne , Integer>{
    Personne findByNomAndPrenom(String nom, String prenom);
}
