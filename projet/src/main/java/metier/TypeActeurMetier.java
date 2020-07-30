package metier;

import java.util.List;

import entities.TypeActeur;

public interface TypeActeurMetier {
	
	public TypeActeur creationTypeActeur(String nom, String description);
	
	public TypeActeur affichageTypeActeurId(Long idType);
	
	public List<TypeActeur> affichageToutTypeActeur();
	
	public TypeActeur majTypeActeur(Long id, String nom, String description);
	
	public void suppressionTypeActeurId(Long idType);
	
	
	

}
