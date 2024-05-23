package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.MentionModel;
import com.todoliste.myapp.models.SemestreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<SemestreModel, Integer> {
}
