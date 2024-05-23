package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.EcModel;
import com.todoliste.myapp.models.MentionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcRepository extends JpaRepository<EcModel, Integer> {
    EcModel findByMatiere(String matiere);
}
