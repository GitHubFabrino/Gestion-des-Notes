package com.todoliste.myapp.repository;

import com.todoliste.myapp.models.MentionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentionRepository extends JpaRepository<MentionModel, Integer> {

    Optional<MentionModel> findByNomMentionAndAbreviationMention(String nom_mention, String abreviation_mention);
}
