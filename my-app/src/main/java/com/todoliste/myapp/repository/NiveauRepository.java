package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.NiveauModel;
import com.todoliste.myapp.models.UeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauRepository extends JpaRepository<NiveauModel, Integer> {
}
