package com.cm.voiture.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Voiture.
 */
@Entity
@Table(name = "voiture")
public class Voiture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "type_vehicule")
    private String typeVehicule;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "usage")
    private String usage;

    @Column(name = "typecarburant")
    private String typecarburant;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "matriculeww")
    private Integer matriculeww;

    @Column(name = "n_chassi")
    private Integer nChassi;

    @Column(name = "capacite")
    private Integer capacite;

    @Column(name = "division")
    private String division;

    @Column(name = "puissancefiscal")
    private Integer puissancefiscal;

    @Column(name = "datemiscirculation")
    private LocalDate datemiscirculation;

    @Column(name = "dateacquisition")
    private LocalDate dateacquisition;

    @Column(name = "affectationdivision")
    private Integer affectationdivision;

    @Column(name = "affectation_service")
    private Integer affectationService;

    @Column(name = "beneficiaire")
    private Integer beneficiaire;

    @Column(name = "kilometrage")
    private Integer kilometrage;

    @Lob
    @Column(name = "piece_jointe")
    private byte[] pieceJointe;

    @Column(name = "piece_jointe_content_type")
    private String pieceJointeContentType;

    @Column(name = "status")
    private String status;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeVehicule() {
        return typeVehicule;
    }

    public Voiture typeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
        return this;
    }

    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public String getMarque() {
        return marque;
    }

    public Voiture marque(String marque) {
        this.marque = marque;
        return this;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public Voiture modele(String modele) {
        this.modele = modele;
        return this;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getUsage() {
        return usage;
    }

    public Voiture usage(String usage) {
        this.usage = usage;
        return this;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getTypecarburant() {
        return typecarburant;
    }

    public Voiture typecarburant(String typecarburant) {
        this.typecarburant = typecarburant;
        return this;
    }

    public void setTypecarburant(String typecarburant) {
        this.typecarburant = typecarburant;
    }

    public String getMatricule() {
        return matricule;
    }

    public Voiture matricule(String matricule) {
        this.matricule = matricule;
        return this;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Integer getMatriculeww() {
        return matriculeww;
    }

    public Voiture matriculeww(Integer matriculeww) {
        this.matriculeww = matriculeww;
        return this;
    }

    public void setMatriculeww(Integer matriculeww) {
        this.matriculeww = matriculeww;
    }

    public Integer getnChassi() {
        return nChassi;
    }

    public Voiture nChassi(Integer nChassi) {
        this.nChassi = nChassi;
        return this;
    }

    public void setnChassi(Integer nChassi) {
        this.nChassi = nChassi;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public Voiture capacite(Integer capacite) {
        this.capacite = capacite;
        return this;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getDivision() {
        return division;
    }

    public Voiture division(String division) {
        this.division = division;
        return this;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Integer getPuissancefiscal() {
        return puissancefiscal;
    }

    public Voiture puissancefiscal(Integer puissancefiscal) {
        this.puissancefiscal = puissancefiscal;
        return this;
    }

    public void setPuissancefiscal(Integer puissancefiscal) {
        this.puissancefiscal = puissancefiscal;
    }

    public LocalDate getDatemiscirculation() {
        return datemiscirculation;
    }

    public Voiture datemiscirculation(LocalDate datemiscirculation) {
        this.datemiscirculation = datemiscirculation;
        return this;
    }

    public void setDatemiscirculation(LocalDate datemiscirculation) {
        this.datemiscirculation = datemiscirculation;
    }

    public LocalDate getDateacquisition() {
        return dateacquisition;
    }

    public Voiture dateacquisition(LocalDate dateacquisition) {
        this.dateacquisition = dateacquisition;
        return this;
    }

    public void setDateacquisition(LocalDate dateacquisition) {
        this.dateacquisition = dateacquisition;
    }

    public Integer getAffectationdivision() {
        return affectationdivision;
    }

    public Voiture affectationdivision(Integer affectationdivision) {
        this.affectationdivision = affectationdivision;
        return this;
    }

    public void setAffectationdivision(Integer affectationdivision) {
        this.affectationdivision = affectationdivision;
    }

    public Integer getAffectationService() {
        return affectationService;
    }

    public Voiture affectationService(Integer affectationService) {
        this.affectationService = affectationService;
        return this;
    }

    public void setAffectationService(Integer affectationService) {
        this.affectationService = affectationService;
    }

    public Integer getBeneficiaire() {
        return beneficiaire;
    }

    public Voiture beneficiaire(Integer beneficiaire) {
        this.beneficiaire = beneficiaire;
        return this;
    }

    public void setBeneficiaire(Integer beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public Voiture kilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
        return this;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public byte[] getPieceJointe() {
        return pieceJointe;
    }

    public Voiture pieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
        return this;
    }

    public void setPieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public String getPieceJointeContentType() {
        return pieceJointeContentType;
    }

    public Voiture pieceJointeContentType(String pieceJointeContentType) {
        this.pieceJointeContentType = pieceJointeContentType;
        return this;
    }

    public void setPieceJointeContentType(String pieceJointeContentType) {
        this.pieceJointeContentType = pieceJointeContentType;
    }

    public String getStatus() {
        return status;
    }

    public Voiture status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Voiture)) {
            return false;
        }
        return id != null && id.equals(((Voiture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Voiture{" +
            "id=" + getId() +
            ", typeVehicule='" + getTypeVehicule() + "'" +
            ", marque='" + getMarque() + "'" +
            ", modele='" + getModele() + "'" +
            ", usage='" + getUsage() + "'" +
            ", typecarburant='" + getTypecarburant() + "'" +
            ", matricule='" + getMatricule() + "'" +
            ", matriculeww=" + getMatriculeww() +
            ", nChassi=" + getnChassi() +
            ", capacite=" + getCapacite() +
            ", division='" + getDivision() + "'" +
            ", puissancefiscal=" + getPuissancefiscal() +
            ", datemiscirculation='" + getDatemiscirculation() + "'" +
            ", dateacquisition='" + getDateacquisition() + "'" +
            ", affectationdivision=" + getAffectationdivision() +
            ", affectationService=" + getAffectationService() +
            ", beneficiaire=" + getBeneficiaire() +
            ", kilometrage=" + getKilometrage() +
            ", pieceJointe='" + getPieceJointe() + "'" +
            ", pieceJointeContentType='" + getPieceJointeContentType() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
