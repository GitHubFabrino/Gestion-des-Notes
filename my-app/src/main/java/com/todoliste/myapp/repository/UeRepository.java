package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.DefinitionParcours;
import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.UeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UeRepository extends JpaRepository<UeModel, Integer> {
    ArrayList<UeModel> findAllByIdDP(DefinitionParcours orElseThrow);
}
