package com.cm.voiture.web.rest;

import com.cm.voiture.VoitureApp;
import com.cm.voiture.domain.Voiture;
import com.cm.voiture.repository.VoitureRepository;
import com.cm.voiture.service.VoitureService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link VoitureResource} REST controller.
 */
@SpringBootTest(classes = VoitureApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class VoitureResourceIT {

    private static final String DEFAULT_TYPE_VEHICULE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE_VEHICULE = "BBBBBBBBBB";

    private static final String DEFAULT_MARQUE = "AAAAAAAAAA";
    private static final String UPDATED_MARQUE = "BBBBBBBBBB";

    private static final String DEFAULT_MODELE = "AAAAAAAAAA";
    private static final String UPDATED_MODELE = "BBBBBBBBBB";

    private static final String DEFAULT_USAGE = "AAAAAAAAAA";
    private static final String UPDATED_USAGE = "BBBBBBBBBB";

    private static final String DEFAULT_TYPECARBURANT = "AAAAAAAAAA";
    private static final String UPDATED_TYPECARBURANT = "BBBBBBBBBB";

    private static final String DEFAULT_MATRICULE = "AAAAAAAAAA";
    private static final String UPDATED_MATRICULE = "BBBBBBBBBB";

    private static final Integer DEFAULT_MATRICULEWW = 1;
    private static final Integer UPDATED_MATRICULEWW = 2;

    private static final Integer DEFAULT_N_CHASSI = 1;
    private static final Integer UPDATED_N_CHASSI = 2;

    private static final Integer DEFAULT_CAPACITE = 1;
    private static final Integer UPDATED_CAPACITE = 2;

    private static final String DEFAULT_DIVISION = "AAAAAAAAAA";
    private static final String UPDATED_DIVISION = "BBBBBBBBBB";

    private static final Integer DEFAULT_PUISSANCEFISCAL = 1;
    private static final Integer UPDATED_PUISSANCEFISCAL = 2;

    private static final LocalDate DEFAULT_DATEMISCIRCULATION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEMISCIRCULATION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_DATEACQUISITION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATEACQUISITION = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_AFFECTATIONDIVISION = 1;
    private static final Integer UPDATED_AFFECTATIONDIVISION = 2;

    private static final Integer DEFAULT_AFFECTATION_SERVICE = 1;
    private static final Integer UPDATED_AFFECTATION_SERVICE = 2;

    private static final Integer DEFAULT_BENEFICIAIRE = 1;
    private static final Integer UPDATED_BENEFICIAIRE = 2;

    private static final Integer DEFAULT_KILOMETRAGE = 1;
    private static final Integer UPDATED_KILOMETRAGE = 2;

    private static final byte[] DEFAULT_PIECE_JOINTE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_PIECE_JOINTE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_PIECE_JOINTE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_PIECE_JOINTE_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    @Autowired
    private VoitureRepository voitureRepository;

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restVoitureMockMvc;

    private Voiture voiture;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Voiture createEntity(EntityManager em) {
        Voiture voiture = new Voiture()
            .typeVehicule(DEFAULT_TYPE_VEHICULE)
            .marque(DEFAULT_MARQUE)
            .modele(DEFAULT_MODELE)
            .usage(DEFAULT_USAGE)
            .typecarburant(DEFAULT_TYPECARBURANT)
            .matricule(DEFAULT_MATRICULE)
            .matriculeww(DEFAULT_MATRICULEWW)
            .nChassi(DEFAULT_N_CHASSI)
            .capacite(DEFAULT_CAPACITE)
            .division(DEFAULT_DIVISION)
            .puissancefiscal(DEFAULT_PUISSANCEFISCAL)
            .datemiscirculation(DEFAULT_DATEMISCIRCULATION)
            .dateacquisition(DEFAULT_DATEACQUISITION)
            .affectationdivision(DEFAULT_AFFECTATIONDIVISION)
            .affectationService(DEFAULT_AFFECTATION_SERVICE)
            .beneficiaire(DEFAULT_BENEFICIAIRE)
            .kilometrage(DEFAULT_KILOMETRAGE)
            .pieceJointe(DEFAULT_PIECE_JOINTE)
            .pieceJointeContentType(DEFAULT_PIECE_JOINTE_CONTENT_TYPE)
            .status(DEFAULT_STATUS);
        return voiture;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Voiture createUpdatedEntity(EntityManager em) {
        Voiture voiture = new Voiture()
            .typeVehicule(UPDATED_TYPE_VEHICULE)
            .marque(UPDATED_MARQUE)
            .modele(UPDATED_MODELE)
            .usage(UPDATED_USAGE)
            .typecarburant(UPDATED_TYPECARBURANT)
            .matricule(UPDATED_MATRICULE)
            .matriculeww(UPDATED_MATRICULEWW)
            .nChassi(UPDATED_N_CHASSI)
            .capacite(UPDATED_CAPACITE)
            .division(UPDATED_DIVISION)
            .puissancefiscal(UPDATED_PUISSANCEFISCAL)
            .datemiscirculation(UPDATED_DATEMISCIRCULATION)
            .dateacquisition(UPDATED_DATEACQUISITION)
            .affectationdivision(UPDATED_AFFECTATIONDIVISION)
            .affectationService(UPDATED_AFFECTATION_SERVICE)
            .beneficiaire(UPDATED_BENEFICIAIRE)
            .kilometrage(UPDATED_KILOMETRAGE)
            .pieceJointe(UPDATED_PIECE_JOINTE)
            .pieceJointeContentType(UPDATED_PIECE_JOINTE_CONTENT_TYPE)
            .status(UPDATED_STATUS);
        return voiture;
    }

    @BeforeEach
    public void initTest() {
        voiture = createEntity(em);
    }

    @Test
    @Transactional
    public void createVoiture() throws Exception {
        int databaseSizeBeforeCreate = voitureRepository.findAll().size();
        // Create the Voiture
        restVoitureMockMvc.perform(post("/api/voitures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(voiture)))
            .andExpect(status().isCreated());

        // Validate the Voiture in the database
        List<Voiture> voitureList = voitureRepository.findAll();
        assertThat(voitureList).hasSize(databaseSizeBeforeCreate + 1);
        Voiture testVoiture = voitureList.get(voitureList.size() - 1);
        assertThat(testVoiture.getTypeVehicule()).isEqualTo(DEFAULT_TYPE_VEHICULE);
        assertThat(testVoiture.getMarque()).isEqualTo(DEFAULT_MARQUE);
        assertThat(testVoiture.getModele()).isEqualTo(DEFAULT_MODELE);
        assertThat(testVoiture.getUsage()).isEqualTo(DEFAULT_USAGE);
        assertThat(testVoiture.getTypecarburant()).isEqualTo(DEFAULT_TYPECARBURANT);
        assertThat(testVoiture.getMatricule()).isEqualTo(DEFAULT_MATRICULE);
        assertThat(testVoiture.getMatriculeww()).isEqualTo(DEFAULT_MATRICULEWW);
        assertThat(testVoiture.getnChassi()).isEqualTo(DEFAULT_N_CHASSI);
        assertThat(testVoiture.getCapacite()).isEqualTo(DEFAULT_CAPACITE);
        assertThat(testVoiture.getDivision()).isEqualTo(DEFAULT_DIVISION);
        assertThat(testVoiture.getPuissancefiscal()).isEqualTo(DEFAULT_PUISSANCEFISCAL);
        assertThat(testVoiture.getDatemiscirculation()).isEqualTo(DEFAULT_DATEMISCIRCULATION);
        assertThat(testVoiture.getDateacquisition()).isEqualTo(DEFAULT_DATEACQUISITION);
        assertThat(testVoiture.getAffectationdivision()).isEqualTo(DEFAULT_AFFECTATIONDIVISION);
        assertThat(testVoiture.getAffectationService()).isEqualTo(DEFAULT_AFFECTATION_SERVICE);
        assertThat(testVoiture.getBeneficiaire()).isEqualTo(DEFAULT_BENEFICIAIRE);
        assertThat(testVoiture.getKilometrage()).isEqualTo(DEFAULT_KILOMETRAGE);
        assertThat(testVoiture.getPieceJointe()).isEqualTo(DEFAULT_PIECE_JOINTE);
        assertThat(testVoiture.getPieceJointeContentType()).isEqualTo(DEFAULT_PIECE_JOINTE_CONTENT_TYPE);
        assertThat(testVoiture.getStatus()).isEqualTo(DEFAULT_STATUS);
    }

    @Test
    @Transactional
    public void createVoitureWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = voitureRepository.findAll().size();

        // Create the Voiture with an existing ID
        voiture.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVoitureMockMvc.perform(post("/api/voitures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(voiture)))
            .andExpect(status().isBadRequest());

        // Validate the Voiture in the database
        List<Voiture> voitureList = voitureRepository.findAll();
        assertThat(voitureList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllVoitures() throws Exception {
        // Initialize the database
        voitureRepository.saveAndFlush(voiture);

        // Get all the voitureList
        restVoitureMockMvc.perform(get("/api/voitures?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(voiture.getId().intValue())))
            .andExpect(jsonPath("$.[*].typeVehicule").value(hasItem(DEFAULT_TYPE_VEHICULE)))
            .andExpect(jsonPath("$.[*].marque").value(hasItem(DEFAULT_MARQUE)))
            .andExpect(jsonPath("$.[*].modele").value(hasItem(DEFAULT_MODELE)))
            .andExpect(jsonPath("$.[*].usage").value(hasItem(DEFAULT_USAGE)))
            .andExpect(jsonPath("$.[*].typecarburant").value(hasItem(DEFAULT_TYPECARBURANT)))
            .andExpect(jsonPath("$.[*].matricule").value(hasItem(DEFAULT_MATRICULE)))
            .andExpect(jsonPath("$.[*].matriculeww").value(hasItem(DEFAULT_MATRICULEWW)))
            .andExpect(jsonPath("$.[*].nChassi").value(hasItem(DEFAULT_N_CHASSI)))
            .andExpect(jsonPath("$.[*].capacite").value(hasItem(DEFAULT_CAPACITE)))
            .andExpect(jsonPath("$.[*].division").value(hasItem(DEFAULT_DIVISION)))
            .andExpect(jsonPath("$.[*].puissancefiscal").value(hasItem(DEFAULT_PUISSANCEFISCAL)))
            .andExpect(jsonPath("$.[*].datemiscirculation").value(hasItem(DEFAULT_DATEMISCIRCULATION.toString())))
            .andExpect(jsonPath("$.[*].dateacquisition").value(hasItem(DEFAULT_DATEACQUISITION.toString())))
            .andExpect(jsonPath("$.[*].affectationdivision").value(hasItem(DEFAULT_AFFECTATIONDIVISION)))
            .andExpect(jsonPath("$.[*].affectationService").value(hasItem(DEFAULT_AFFECTATION_SERVICE)))
            .andExpect(jsonPath("$.[*].beneficiaire").value(hasItem(DEFAULT_BENEFICIAIRE)))
            .andExpect(jsonPath("$.[*].kilometrage").value(hasItem(DEFAULT_KILOMETRAGE)))
            .andExpect(jsonPath("$.[*].pieceJointeContentType").value(hasItem(DEFAULT_PIECE_JOINTE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].pieceJointe").value(hasItem(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE))))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)));
    }
    
    @Test
    @Transactional
    public void getVoiture() throws Exception {
        // Initialize the database
        voitureRepository.saveAndFlush(voiture);

        // Get the voiture
        restVoitureMockMvc.perform(get("/api/voitures/{id}", voiture.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(voiture.getId().intValue()))
            .andExpect(jsonPath("$.typeVehicule").value(DEFAULT_TYPE_VEHICULE))
            .andExpect(jsonPath("$.marque").value(DEFAULT_MARQUE))
            .andExpect(jsonPath("$.modele").value(DEFAULT_MODELE))
            .andExpect(jsonPath("$.usage").value(DEFAULT_USAGE))
            .andExpect(jsonPath("$.typecarburant").value(DEFAULT_TYPECARBURANT))
            .andExpect(jsonPath("$.matricule").value(DEFAULT_MATRICULE))
            .andExpect(jsonPath("$.matriculeww").value(DEFAULT_MATRICULEWW))
            .andExpect(jsonPath("$.nChassi").value(DEFAULT_N_CHASSI))
            .andExpect(jsonPath("$.capacite").value(DEFAULT_CAPACITE))
            .andExpect(jsonPath("$.division").value(DEFAULT_DIVISION))
            .andExpect(jsonPath("$.puissancefiscal").value(DEFAULT_PUISSANCEFISCAL))
            .andExpect(jsonPath("$.datemiscirculation").value(DEFAULT_DATEMISCIRCULATION.toString()))
            .andExpect(jsonPath("$.dateacquisition").value(DEFAULT_DATEACQUISITION.toString()))
            .andExpect(jsonPath("$.affectationdivision").value(DEFAULT_AFFECTATIONDIVISION))
            .andExpect(jsonPath("$.affectationService").value(DEFAULT_AFFECTATION_SERVICE))
            .andExpect(jsonPath("$.beneficiaire").value(DEFAULT_BENEFICIAIRE))
            .andExpect(jsonPath("$.kilometrage").value(DEFAULT_KILOMETRAGE))
            .andExpect(jsonPath("$.pieceJointeContentType").value(DEFAULT_PIECE_JOINTE_CONTENT_TYPE))
            .andExpect(jsonPath("$.pieceJointe").value(Base64Utils.encodeToString(DEFAULT_PIECE_JOINTE)))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS));
    }
    @Test
    @Transactional
    public void getNonExistingVoiture() throws Exception {
        // Get the voiture
        restVoitureMockMvc.perform(get("/api/voitures/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVoiture() throws Exception {
        // Initialize the database
        voitureService.save(voiture);

        int databaseSizeBeforeUpdate = voitureRepository.findAll().size();

        // Update the voiture
        Voiture updatedVoiture = voitureRepository.findById(voiture.getId()).get();
        // Disconnect from session so that the updates on updatedVoiture are not directly saved in db
        em.detach(updatedVoiture);
        updatedVoiture
            .typeVehicule(UPDATED_TYPE_VEHICULE)
            .marque(UPDATED_MARQUE)
            .modele(UPDATED_MODELE)
            .usage(UPDATED_USAGE)
            .typecarburant(UPDATED_TYPECARBURANT)
            .matricule(UPDATED_MATRICULE)
            .matriculeww(UPDATED_MATRICULEWW)
            .nChassi(UPDATED_N_CHASSI)
            .capacite(UPDATED_CAPACITE)
            .division(UPDATED_DIVISION)
            .puissancefiscal(UPDATED_PUISSANCEFISCAL)
            .datemiscirculation(UPDATED_DATEMISCIRCULATION)
            .dateacquisition(UPDATED_DATEACQUISITION)
            .affectationdivision(UPDATED_AFFECTATIONDIVISION)
            .affectationService(UPDATED_AFFECTATION_SERVICE)
            .beneficiaire(UPDATED_BENEFICIAIRE)
            .kilometrage(UPDATED_KILOMETRAGE)
            .pieceJointe(UPDATED_PIECE_JOINTE)
            .pieceJointeContentType(UPDATED_PIECE_JOINTE_CONTENT_TYPE)
            .status(UPDATED_STATUS);

        restVoitureMockMvc.perform(put("/api/voitures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedVoiture)))
            .andExpect(status().isOk());

        // Validate the Voiture in the database
        List<Voiture> voitureList = voitureRepository.findAll();
        assertThat(voitureList).hasSize(databaseSizeBeforeUpdate);
        Voiture testVoiture = voitureList.get(voitureList.size() - 1);
        assertThat(testVoiture.getTypeVehicule()).isEqualTo(UPDATED_TYPE_VEHICULE);
        assertThat(testVoiture.getMarque()).isEqualTo(UPDATED_MARQUE);
        assertThat(testVoiture.getModele()).isEqualTo(UPDATED_MODELE);
        assertThat(testVoiture.getUsage()).isEqualTo(UPDATED_USAGE);
        assertThat(testVoiture.getTypecarburant()).isEqualTo(UPDATED_TYPECARBURANT);
        assertThat(testVoiture.getMatricule()).isEqualTo(UPDATED_MATRICULE);
        assertThat(testVoiture.getMatriculeww()).isEqualTo(UPDATED_MATRICULEWW);
        assertThat(testVoiture.getnChassi()).isEqualTo(UPDATED_N_CHASSI);
        assertThat(testVoiture.getCapacite()).isEqualTo(UPDATED_CAPACITE);
        assertThat(testVoiture.getDivision()).isEqualTo(UPDATED_DIVISION);
        assertThat(testVoiture.getPuissancefiscal()).isEqualTo(UPDATED_PUISSANCEFISCAL);
        assertThat(testVoiture.getDatemiscirculation()).isEqualTo(UPDATED_DATEMISCIRCULATION);
        assertThat(testVoiture.getDateacquisition()).isEqualTo(UPDATED_DATEACQUISITION);
        assertThat(testVoiture.getAffectationdivision()).isEqualTo(UPDATED_AFFECTATIONDIVISION);
        assertThat(testVoiture.getAffectationService()).isEqualTo(UPDATED_AFFECTATION_SERVICE);
        assertThat(testVoiture.getBeneficiaire()).isEqualTo(UPDATED_BENEFICIAIRE);
        assertThat(testVoiture.getKilometrage()).isEqualTo(UPDATED_KILOMETRAGE);
        assertThat(testVoiture.getPieceJointe()).isEqualTo(UPDATED_PIECE_JOINTE);
        assertThat(testVoiture.getPieceJointeContentType()).isEqualTo(UPDATED_PIECE_JOINTE_CONTENT_TYPE);
        assertThat(testVoiture.getStatus()).isEqualTo(UPDATED_STATUS);
    }

    @Test
    @Transactional
    public void updateNonExistingVoiture() throws Exception {
        int databaseSizeBeforeUpdate = voitureRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVoitureMockMvc.perform(put("/api/voitures")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(voiture)))
            .andExpect(status().isBadRequest());

        // Validate the Voiture in the database
        List<Voiture> voitureList = voitureRepository.findAll();
        assertThat(voitureList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteVoiture() throws Exception {
        // Initialize the database
        voitureService.save(voiture);

        int databaseSizeBeforeDelete = voitureRepository.findAll().size();

        // Delete the voiture
        restVoitureMockMvc.perform(delete("/api/voitures/{id}", voiture.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Voiture> voitureList = voitureRepository.findAll();
        assertThat(voitureList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
