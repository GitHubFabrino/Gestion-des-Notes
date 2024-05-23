package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnneeUniversitaireRepository extends JpaRepository<AnneeUniversitaireModel, Integer> {
}
