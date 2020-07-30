package metier;

import java.util.Date;
import java.util.List;

import entities.Compte;
import entities.Statut;
import entities.TypeActeur;
import entities.Ville;

public interface CompteMetier {
	
	public Compte creationCompteIndividu(String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, TypeActeur typeActeur,
			Statut statut, Ville ville);
	
	public Compte creationCompteOragnisation(String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, TypeActeur typeActeur, Statut statut,
			Ville ville);
	
	public Compte affichageCompteId(Long idCompte);
	
	public List<Compte> affichageToutCompte();
	
	public List<Compte> affichageCompteDept(Long idDept);
	
	public List<Compte> affichageCompteVille(Long idVille);
	
	public List<Compte> affichageCompteActif();
	
	public Compte majCompteIndividuId(Long idCompte, String nom, String prenom, String email, String mdp,
			String rue, String codePostal, String tel, Date dateNaiss, Ville ville);
	
	public Compte majCompteOrganisationId (Long idCompte, String nomOrganisation, String email, String mdp,
			String rue, String codePostal, String tel, Date dateCrea, String numSiret, Ville ville);
	
	public void activationCompteId(Long idCompte);
	
	public void inactivationCompteId(Long idCompte);
	
	public void suppressionCompteId(Long idCompte);
	
	

}
