package entities;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Profil implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( length = 612, nullable = false)
	private String presentation;
	
	@Column(nullable = true)
	private String photoProfil;
	
	@Column( length = 612, nullable = false)
	private String offre;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dateCreation;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDesactivation;
	
	@ManyToOne
	private Compte compte;
	
	@ManyToOne
	private Statut statut;
	
	@OneToMany(mappedBy = "profil")
	private Collection<ReseauSocial> reseaux;
	
	@ManyToMany(mappedBy = "profils")
	private Collection<Administrateur> admins;

	@ManyToMany(mappedBy = "profils")
	private Collection<Service> services;

	public Profil() {
		reseaux= new ArrayList<>();
		admins= new ArrayList<>();
		services= new ArrayList<>();
	}

	public Profil(String presentation, String photoProfil, String offre, Compte compte) {
		this();
		this.presentation = presentation;
		this.photoProfil = photoProfil;
		this.offre = offre;
		this.compte = compte;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Collection<ReseauSocial> getReseaux() {
		return reseaux;
	}

	public void setReseaux(Collection<ReseauSocial> reseaux) {
		this.reseaux = reseaux;
	}

	public Collection<Administrateur> getAdmins() {
		return admins;
	}

	public void setAdmins(Collection<Administrateur> admins) {
		this.admins = admins;
	}

	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public String getOffre() {
		return offre;
	}

	public void setOffre(String offre) {
		this.offre = offre;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public Date getDateDesactivation() {
		return dateDesactivation;
	}

	public void setDateDesactivation(Date dateDesactivation) {
		this.dateDesactivation = dateDesactivation;
	}
	
	

	@Override
	public String toString() {
		return "Profil [id=" + id + ", presentation=" + presentation + ", offre=" + offre + ", dateCreation=" + dateCreation 
				+ ", dateModification=" + dateModification + ", dateDesactivation=" + dateDesactivation + "]";
	}
	
	

}

