package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.DefinitionMentionModel;
import com.todoliste.myapp.models.UeEcModel;
import com.todoliste.myapp.models.UeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UeEcRepository extends JpaRepository<UeEcModel, Integer> {
    ArrayList<UeEcModel> findAllByIdUe(UeModel ue);
}
