package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.CursusModel;
import com.todoliste.myapp.models.ReleveeModel;
import com.todoliste.myapp.models.UeEcModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ReleverRepository extends JpaRepository<ReleveeModel, Integer> {
    ReleveeModel findByIdCursusAndIdUeEc(CursusModel cursusExist, UeEcModel ueec);

    ArrayList<ReleveeModel> findByIdCursus(Optional<CursusModel> cursusModel);
}
