package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Departement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column( length = 3)
	private String code;
	
	@Column( length =255)
	private String nom;
	
	@Column( length = 255)
	private String nom_uppercase;
	
	@Column( length = 255)
	private String slug;
	
	@Column( length = 120)
	private String nom_soundex;
	
	@OneToMany (mappedBy = "departement")
	private Collection<Ville> villes;
	
	@ManyToOne
	private Pays pays;

	public Departement() {
		villes = new ArrayList<>();
	}
	
	public Departement(Long id) {
		this.id = id;
	}
	

	public Departement(String code, String nom, String nom_uppercase, String slug, String nom_soundex, Pays pays) {
		this.code = code;
		this.nom = nom;
		this.nom_uppercase = nom_uppercase;
		this.slug = slug;
		this.nom_soundex = nom_soundex;
		this.pays = pays;
	}

	public Departement(Long id, String code, String nom, String nom_uppercase, String slug, String nom_soundex,
			Pays pays) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.nom_uppercase = nom_uppercase;
		this.slug = slug;
		this.nom_soundex = nom_soundex;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom_uppercase() {
		return nom_uppercase;
	}

	public void setNom_uppercase(String nom_uppercase) {
		this.nom_uppercase = nom_uppercase;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getNom_soundex() {
		return nom_soundex;
	}

	public void setNom_soundex(String nom_soundex) {
		this.nom_soundex = nom_soundex;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	

	public Collection<Ville> getVilles() {
		return villes;
	}

	public void setVilles(Collection<Ville> villes) {
		this.villes = villes;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", code=" + code + ", nom=" + nom + "]";
	}


}
