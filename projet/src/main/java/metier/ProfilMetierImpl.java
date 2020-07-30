package metier;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import entities.*;
import repository.*;
import metier.IProfilMetier;

@Service("profilMetier")
public class ProfilMetierImpl implements IProfilMetier {
	
	private static String stDesact = "P002";
	private static String stVlid = "P003";
	
	@Autowired
	@Qualifier("profilRep")
	private IProfilRepository profilRep;
	
	@Autowired
	private StatutDaoImpl statutRep;
	
	@Override
	public Profil addProfil(String presentation, String photoProfil, String offre,Compte compte) {
		
		Profil profil = new Profil();
		Statut statut = statutRep.selectStatutById(stVlid);
		profil.setCompte(compte);
		profil.setDateCreation(new Date());
		profil.setDateDesactivation(null);
		profil.setDateModification(new Date());
		profil.setOffre(offre);
		profil.setPhotoProfil(photoProfil);
		profil.setPresentation(presentation);
		profil.setStatut(statut);
		profilRep.save(profil);
		
		return profil;
	}

	@Override
	public Profil FindProfilById(Long id) {
		Profil profil = profilRep.findById(id).orElse(null);// il faut vérifier dans le controller la possibilité d'avoir un null
		return profil;
	}

	@Override
	public void updateProfil(Profil profil) {
		profil.setDateModification(new Date());
		profilRep.save(profil);
	}

	@Override
	public void deleteProfil(Profil profil) {
		profilRep.deleteById(profil.getId());
	}

	@Override
	public void desactiverProfil(Profil profil) {
		Statut statut = statutRep.selectStatutById(stDesact);
		profil.setDateDesactivation(new Date());
		profil.setStatut(statut);
		profilRep.save(profil);
	}

	@Override
	public List<Profil> findProfilAValider() {
		List<Profil> profils = profilRep.findProfilByIdStatus(stVlid);
		return profils;
	}

	@Override
	public Profil findProfilByIdCompte(Long idCompte) {
		Profil p = profilRep.findProfilByIdCompte(idCompte);
		return p;
	}
	
	public List<entities.Service> findServiceByIdProfil(Long idProfil) {
		List<entities.Service> listeS = profilRep.findServicesByProfil(idProfil);
		return listeS;
	}
	
	public List<Profil> findProfilHome(String search){
		List<Profil> profils = profilRep.findProfilHome(search);
		return profils;
		
	}
	
}
