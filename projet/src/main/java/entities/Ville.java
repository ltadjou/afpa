package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Ville implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 256, nullable = false)
	private String nom;


	@ManyToOne(cascade = {CascadeType.ALL})
	private Departement departement;
	
	@OneToMany (mappedBy = "ville")
	private Collection<Compte> comptes;

	public Ville() {
		comptes = new ArrayList<>();
	}
	
	public Ville(String nom) {
		this();
		this.nom = nom;
	}

	public Ville(String nom, Departement departement) {
		this();
		this.nom = nom;
		this.departement = departement;
	}
	
	

	public Ville(Long id) {
		this.id = id;
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

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public Collection<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + ", departement=" + departement + "]";
	}
	
	
}
