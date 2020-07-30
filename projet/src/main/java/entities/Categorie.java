package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Categorie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column()
	private Long id;
	@Column (length = 75, nullable = false)
	private String nom;
	
	@Column(length = 300,nullable =false)
	private String description;
	
	@OneToMany(mappedBy ="categorie")
	private Collection<Acteur> acteurs;
	
	public Categorie(String nom, String description) {
		this.nom = nom;
		this.description=description;
		
	}
	public Categorie() {
		acteurs = new ArrayList<>();
			
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
		return ""+ nom ;
	}

}
