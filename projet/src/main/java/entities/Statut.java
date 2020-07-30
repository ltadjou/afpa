package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Statut implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//PROPRIETES
	@Id
	@Column(unique = true, length = 4, nullable = false)
	private String id;
	
	@Column(unique = true, length = 80, nullable = false)
	private String nom;
	
	@Column(length = 80, nullable = false)
	private String relEntity;
	
	@Column(nullable = true) 
	private Boolean admin;
	
	//ASSOCIATIONS
	@OneToMany(mappedBy = "statut")
	private Collection<Administrateur> admins;
	
	@OneToMany(mappedBy = "statut")
	private Collection<Compte> comptes;
	
	@OneToMany(mappedBy = "statut")
	private Collection<Profil> profils;

	// CONSTRUCTORS
	public Statut() {
		admins = new ArrayList<>();
		comptes = new ArrayList<>();
		profils = new ArrayList<>();
	}
	
	public Statut(String id, String nom, String relEntity) {
		this();
		this.id = id;
		this.nom = nom;
		this.relEntity = relEntity;
	}

	// GETTERS AND SETTERS
	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}
	
	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Collection<Administrateur> getAdmins() {
		return admins;
	}

	public void setAdmins(Collection<Administrateur> admins) {
		this.admins = admins;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRelEntity() {
		return relEntity;
	}

	public void setRelEntity(String relEntity) {
		this.relEntity = relEntity;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Statut [id=" + id + ", nom=" + nom + ", admin=" + admin + "]";
	}	
}
