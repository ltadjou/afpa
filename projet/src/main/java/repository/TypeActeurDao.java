package repository;

import java.util.List;

import entities.TypeActeur;

public interface TypeActeurDao {
	public TypeActeur insertTypeActeur(String nom, String description);
	
	public TypeActeur selectTypeActeurById(Long id);
	
	public List<TypeActeur> selectTypeActeur();
	
	public TypeActeur updateTypeActeurById(Long id, String nom, String description);
	
	public void deleteTypeActeurById(Long id);

}
