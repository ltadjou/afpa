package repository;

import java.util.List;

import entities.Departement;
import entities.Ville;

public interface VilleDao {
	
	public Ville insertVille(String nom, Departement departement);
	public Ville selectVilleById(Long idVille);
	public List<Ville> selectAllVilleDept(Long idDept);
	public Ville updateVilleById(Long idVille, String nom, Long idDept);
	public void deleteVilleById(Long idville);

}