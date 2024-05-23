package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.DefinitionMentionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface DMRepository extends JpaRepository<DefinitionMentionModel, Integer> {


    ArrayList<DefinitionMentionModel> findAllByIdAU(AnneeUniversitaireModel idAu);
}
