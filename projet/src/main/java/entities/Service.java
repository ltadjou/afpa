package entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

@Entity
public class Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = false)
	private String nom;
	
	@Column( length = 200, nullable = false)
	private String description;
	
	@ManyToOne
	private Acteur acteur;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Profil> profils;
	
	public Service() {
		profils = new ArrayList<>();
	}
	
	public Service(String nom, String description) {
		this();
		this.nom = nom;
		this.description=description;
		
	}
	
	
	public Service(String nom, String description, Acteur acteur) {
		this();
		this.nom = nom;
		this.description = description;
		this.acteur = acteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Service [id=" + id +"Nom=  "+ nom + ", Description=" + description + "]";
	}

}
