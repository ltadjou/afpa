package repository;

import java.util.List;

import entities.Statut;

public interface StatutDao {
	public Statut insertStatut(String id, String name, String entite);
	public Statut insertStatut(Statut st);
	public Statut selectStatutById(String idStatut);
	public List<Statut> selectStatutByEntity(String entity);
	public Statut updateStatut(Statut st);
	public Integer deleteStatutByName(String stName);
}
