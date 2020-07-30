package metier;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import entities.Compte;
import entities.Statut;
import entities.TypeActeur;
import entities.Ville;
import repository.CompteDao;

@Service("compteMetier")
public class CompteMetierImpl implements CompteMetier {
	
	@Autowired
	@Qualifier("compteDao")
	private CompteDao compteDao;

	@Override
	public Compte creationCompteIndividu(String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, TypeActeur typeActeur, Statut statut, Ville ville) {
		Compte c01 = compteDao.insertCompteIndividu(nom, prenom, email, mdp, rue, codePostal, tel, dateNaiss, typeActeur, statut, ville);
		return c01;
	}

	@Override
	public Compte creationCompteOragnisation(String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, TypeActeur typeActeur, Statut statut,
			Ville ville) {
		Compte c02 = compteDao.insertCompteOrganisation(nomOrganisation, email, mdp, rue, codePostal, tel, dateCrea, numSiret, typeActeur, statut, ville);
		return c02;
	}

	@Override
	public Compte affichageCompteId(Long idCompte) {
		Compte c03 = compteDao.selectCompteById(idCompte);
		return c03;
	}

	@Override
	public List<Compte> affichageToutCompte() {
		List<Compte> listc = compteDao.selectAllCompte();
		return listc;
	}

	@Override
	public List<Compte> affichageCompteDept(Long idDept) {
		List<Compte> listc = compteDao.selectAllCompteByDept(idDept);
		return listc;
	}

	@Override
	public List<Compte> affichageCompteVille(Long idVille) {
		List<Compte> listc = compteDao.selectAllCompteByVille(idVille);
		return listc;
	}

	@Override
	public List<Compte> affichageCompteActif() {
		List<Compte> listc = compteDao.selectAllCompteActive();
		return listc;
	}

	@Override
	public Compte majCompteIndividuId(Long idCompte, String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, Ville ville) {
		Compte c = compteDao.updateCompteIndividuById(idCompte, nom, prenom, email, mdp, rue, codePostal, tel, dateNaiss, ville);
		return c;
	}

	@Override
	public Compte majCompteOrganisationId(Long idCompte, String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, Ville ville) {
		Compte c = compteDao.updateCompteOrganisationById(idCompte, nomOrganisation, email, mdp, rue, codePostal, tel, dateCrea, numSiret, ville);
		return c;
	}

	@Override
	public void activationCompteId(Long idCompte) {
		compteDao.activationCompteById(idCompte);
		
	}

	@Override
	public void inactivationCompteId(Long idCompte) {
		compteDao.inactivationCompteById(idCompte);
		
	}

	@Override
	public void suppressionCompteId(Long idCompte) {
		compteDao.deleteCompteById(idCompte);
		
	}
	
	
	
	
	
	

}
