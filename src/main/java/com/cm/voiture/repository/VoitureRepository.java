package com.cm.voiture.repository;

import com.cm.voiture.domain.Voiture;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Voiture entity.
 */
@SuppressWarnings("unused")
@Repository

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    @Query("SELECT V FROM Voiture V WHERE V.status= :status")
    List<Voiture> findVoituredisponible( @Param("status") String status);
    Voiture findVoitureByMatricule(String matricule);
}
