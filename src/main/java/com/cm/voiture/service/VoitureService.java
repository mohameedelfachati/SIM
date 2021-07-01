package com.cm.voiture.service;

import com.cm.voiture.domain.Voiture;
import com.cm.voiture.repository.VoitureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Voiture}.
 */
@Service
@Transactional
public class VoitureService {

    private final Logger log = LoggerFactory.getLogger(VoitureService.class);

    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    /**
     * Save a voiture.
     *
     * @param voiture the entity to save.
     * @return the persisted entity.
     */
    public Voiture save(Voiture voiture) {
        log.debug("Request to save Voiture : {}", voiture);
        return voitureRepository.save(voiture);
    }

    /**
     * Get all the voitures.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Voiture> findAll(Pageable pageable) {
        log.debug("Request to get all Voitures");
        return voitureRepository.findAll(pageable);
    }


    /**
     * Get one voiture by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Voiture> findOne(Long id) {
        log.debug("Request to get Voiture : {}", id);
        return voitureRepository.findById(id);
    }

    /**
     * Delete the voiture by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Voiture : {}", id);
        voitureRepository.deleteById(id);
    }
    public Voiture getVoiture(String matricule){
        return voitureRepository.findVoitureByMatricule(matricule);
    }
    public List<Voiture> getVoitureDispo(){
        return voitureRepository.findVoituredisponible("DISPONIBLE");
    }
}
