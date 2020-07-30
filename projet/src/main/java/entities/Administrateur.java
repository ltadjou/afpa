package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Administrateur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//PROPRIETES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 30, nullable = false)
	private String identifiant;
	
	@Column(length = 30, nullable = false)
	private String mdp;
	
	@Column(length = 80, nullable = false)
	private String nom;
	
	@Column(length = 80, nullable = false)
	private String prenom;
	
	@Column(unique = true, length = 6, nullable = false)
	private String numEmploye;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateEntree;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSortie;

	//ASSOCIATIONS
	@ManyToOne
	private Statut statut;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Profil> profils;
	
	// CONSTRUCTORS
	public Administrateur() {
		profils = new ArrayList<>();
	}

	public Administrateur(Long id, String identifiant, String mdp, String nom, String prenom, String numEmploye,
			Date dateEntree, Date dateSortie, Statut statut) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.numEmploye = numEmploye;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.statut = statut;
	}

	public Administrateur(String identifiant, String mdp, String nom, String prenom, String numEmploye, Date dateEntree,
			Statut statut) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.numEmploye = numEmploye;
		this.dateEntree = dateEntree;
		this.statut = statut;
	}

	// GETTERS AND SETTERS
	public Boolean getActif() {
		if(statut == null) {
			return false;
		}
		return "A001".equals(statut.getId());
	}
	
	public Statut getStatut() {
		return statut;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumEmploye() {
		return numEmploye;
	}

	public void setNumEmploye(String numEmploye) {
		this.numEmploye = numEmploye;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	@Override
	public String toString() {
		return "Administrateur [id=" + id + ", identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom
				+ ", numEmploye=" + numEmploye + ", dateEntree=" + dateEntree + ", dateSortie=" + dateSortie + "]";
	}
	
}
