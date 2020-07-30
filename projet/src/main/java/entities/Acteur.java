package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Acteur implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	
	@Column( length = 75, nullable = false)
	private String nom;
	
	@Column( length = 300,nullable =false)
	private String description;
	
	@ManyToOne
	private Categorie categorie;
	
	//@JsonIgnore
	@OneToMany (mappedBy = "acteur")
	private Collection<Service>services;
	
	public Acteur() {
	 services = new ArrayList<>();
}

	
public Acteur(String nom, String description) {
	this();
	this.nom = nom;
	this.description=description;
	
}



public Acteur(String nom, String description, Categorie categorie) {
	this();
	this.nom = nom;
	this.description = description;
	this.categorie = categorie;
}


public Long getId() {
	return id;
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
	return "Acteur [id=" + id +"Nom=  "+ nom + ", Description=" + description + "]";
}
}
