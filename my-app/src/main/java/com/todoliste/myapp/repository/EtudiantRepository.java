package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.DefinitionMentionModel;
import com.todoliste.myapp.models.EtudiantModel;
import com.todoliste.myapp.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<EtudiantModel, Integer> {
  EtudiantModel findByIdEtudiant(Personne personneExist);


  EtudiantModel findByIdPersonne(Personne personneExist1);

  // EtudiantModel findById_Etudiant(Personne personneExist);
}
