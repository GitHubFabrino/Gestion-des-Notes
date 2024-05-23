package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.CursusModel;
import com.todoliste.myapp.models.DefinitionMentionModel;
import com.todoliste.myapp.models.DefinitionParcours;
import com.todoliste.myapp.models.EtudiantModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface CursusRepository extends JpaRepository<CursusModel, Integer> {
    CursusModel findByIdEtudiantAndIdDP(EtudiantModel etudiantExist, Optional<DefinitionParcours> byId);

    ArrayList<CursusModel> findByIdDP(Optional<DefinitionParcours> byId);
}
