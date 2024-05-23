package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.AnneeUniversitaireModel;
import com.todoliste.myapp.models.DefinitionMentionModel;
import com.todoliste.myapp.models.DefinitionParcours;
import com.todoliste.myapp.models.NiveauModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface DParcoursReository extends JpaRepository<DefinitionParcours, Integer> {
    ArrayList<DefinitionParcours> findAllByIdAU(Optional<AnneeUniversitaireModel> byId);

    //ArrayList<DefinitionParcours> findAllByIdAUAndIdDM(Optional<AnneeUniversitaireModel> byId, Optional<DefinitionMentionModel> byId1);

    ArrayList<DefinitionParcours> findAllByIdAUAndIdDMAndIdNiveau(Optional<AnneeUniversitaireModel> byId, Optional<DefinitionMentionModel> byId1, Optional<NiveauModel> id);
}
