package metier;

import java.util.List;

import entities.Departement;
import entities.Ville;

public interface VilleMetier {
	
	public Ville creationVille(String nom, Departement departement);
	
	public Ville affichageVilleId(Long idVille);
	
	public List<Ville> affichageVilleDept(Long idDept);
	
	public Ville majVilleId(Long idVille, String nom, Long idDept);
	
	public void suppressionVilleId(Long idVille);
	

}
