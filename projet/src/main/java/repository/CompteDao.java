package repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import entities.Compte;
import entities.Profil;
import entities.Statut;
import entities.TypeActeur;
import entities.Ville;


public interface CompteDao {
	
	public Compte insertCompteIndividu(String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, TypeActeur typeActeur,
			Statut statut, Ville ville);
	
	public Compte insertCompteOrganisation(String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, TypeActeur typeActeur,
			Statut statut, Ville ville);
	
	public Compte selectCompteById(Long idCompte);
	
	public List<Compte> selectAllCompte();
	
	public List<Compte> selectAllCompteByDept(Long idDept);
	
	public List<Compte> selectAllCompteByVille(Long idVille);
	
	public Compte updateCompteIndividuById(Long idCompte, String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, Ville ville);
	
	public Compte updateCompteOrganisationById(Long idCompte, String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, Ville ville);
	
	public List<Compte> selectAllCompteActive();
	
	public void activationCompteById(Long idCompte);
	
	public void inactivationCompteById(Long idCompte);
	
	public void deleteCompteById(Long idCompte);

}
