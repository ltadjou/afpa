package metier;

import java.util.*;
import entities.*;

public interface IProfilMetier {
	
	public Profil addProfil(String presentation, String photoProfil, String offre,  Compte compte);
	
	public Profil FindProfilById(Long id);
	
	public void updateProfil(Profil profil);
	
	public void deleteProfil(Profil profil);
	
	public void desactiverProfil(Profil profil);
	
	public List<Profil> findProfilAValider();
	
	public Profil findProfilByIdCompte(Long idCompte);

}
