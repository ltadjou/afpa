package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReseauSocial implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//PROPRIETES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = true)
	private String nom;
	
	@Column(unique = true, length = 200, nullable = true)
	private String url;
	
	// ASSOCIATION
	@ManyToOne
	private Profil profil;
	
	// CONSTRUCTORS
	public ReseauSocial() {
		
	}

	public ReseauSocial(String nom, String url) {
		this.nom = nom;
		this.url = url;
	}
	
	// GETTERS AND SETTERS
	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ReseauSocial [id=" + id + ", nom=" + nom + ", url=" + url + "]";
	}
	
	

}
