package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 75, nullable = true)
	private String nom;
	
	@Column(length = 75, nullable = true)
	private String prenom;
	
	@Column(length = 75, nullable = true)
	private String nomOrganisation;
	
	@Column(unique = true, length = 100, nullable = false)
	private String email;
	
	@Column(length = 30, nullable = false)
	private String mdp;
	
	@Column(length = 100, nullable = false)
	private String rue;
	
	@Column(length = 30, nullable = false)
	private String codePostal;
	
	@Column(length = 30, nullable = false)
	private String tel;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date dateNaiss;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date dateCrea;
	
	@Column(length = 75, nullable = true)
	private String numSiret;
	
	@ManyToOne
	private TypeActeur typeActeur;
	
	@ManyToOne
	private Statut statut;
	
	@ManyToOne
	private Ville ville;
	
	@OneToMany (mappedBy = "compte", fetch = FetchType.EAGER)
	private Collection<Profil> profils;

	public Compte() {
		profils = new ArrayList<>();
		
	}

	public Compte(Long id, String nom, String prenom, String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, Date dateCrea, String numSiret, TypeActeur typeActeur,
			Statut statut, Ville ville, Collection<Profil> profils) {
		this();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.nomOrganisation = nomOrganisation;
		this.email = email;
		this.mdp = mdp;
		this.rue = rue;
		this.codePostal = codePostal;
		this.tel = tel;
		this.dateNaiss = dateNaiss;
		this.dateCrea = dateCrea;
		this.numSiret = numSiret;
		this.typeActeur = typeActeur;
		this.statut = statut;
		this.ville = ville;
		this.profils = profils;
	}

	public Compte(String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, TypeActeur typeActeur,
			Statut statut, Ville ville) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.rue = rue;
		this.codePostal = codePostal;
		this.tel = tel;
		this.dateNaiss = dateNaiss;
		this.typeActeur = typeActeur;
		this.statut = statut;
		this.ville = ville;
	}
	
	public Compte(String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, TypeActeur typeActeur,
			Statut statut, Ville ville) {
		this();
		this.nomOrganisation = nomOrganisation;
		this.email = email;
		this.mdp = mdp;
		this.rue = rue;
		this.codePostal = codePostal;
		this.tel = tel;
		this.dateCrea = dateCrea;
		this.numSiret = numSiret;
		this.typeActeur = typeActeur;
		this.statut = statut;
		this.ville = ville;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomOrganisation() {
		return nomOrganisation;
	}

	public void setNomOrganisation(String nomOrganisation) {
		this.nomOrganisation = nomOrganisation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMDP() {
		return mdp;
	}

	public void setMDP(String mdp) {
		this.mdp = mdp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public Date getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(Date dateCrea) {
		this.dateCrea = dateCrea;
	}

	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public TypeActeur getTypeActeur() {
		return typeActeur;
	}

	public void setTypeActeur(TypeActeur typeActeur) {
		this.typeActeur = typeActeur;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Collection<Profil> getProfils() {
		return profils;
	}

	public void setProfils(Collection<Profil> profils) {
		this.profils = profils;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nomOrganisation=" + nomOrganisation
				+ ", email=" + email + ", MDP=" + mdp + ", Rue=" + rue + ", codePostal=" + codePostal + ", tel=" + tel
				+ ", dateNaiss=" + dateNaiss + ", dateCrea=" + dateCrea + ", numSiret=" + numSiret + ", typeActeur="
				+ typeActeur + ", statut=" + statut + ", ville=" + ville + ", profils=" + profils + "]";
		
		/*return "Compte [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", nomOrganisation=" + nomOrganisation
				+ ", email=" + email + ", MDP=" + mdp + ", Rue=" + rue + ", codePostal=" + codePostal + ", tel=" + tel
				+ ", dateNaiss=" + dateNaiss + ", dateCrea=" + dateCrea + ", numSiret=" + numSiret + ", typeActeur="
				+ typeActeur + ", statut=" + statut + ", ville=" + ville + "]";*/
	}
	
	
	
	
	
	
	
	
	
	
	

}
