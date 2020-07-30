package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Statut;

@Repository("statutDao")
@Transactional
public class StatutDaoImpl implements StatutDao {

	@Autowired
	private EntityManager em;
	
	public Statut insertStatut(String id, String name, String entite) {
		Statut st = new Statut(id, name, entite);
		em.persist(st);
		return st;
	}
	
	public Statut insertStatut(Statut st) {
		em.persist(st);
		return st;
	}
	
	public Statut selectStatutById(String idStatut) {
		Statut st = em.find(Statut.class, idStatut);
		return st;
	}
	
	public List<Statut> selectStatutByEntity(String entity){
		String jpql = "select s from Statut s where s.relEntity = :paramEntity";
		TypedQuery<Statut> qr = em.createQuery(jpql, Statut.class);
		qr.setParameter("paramEntity", entity);
		List<Statut> result = qr.getResultList();
		return result;
	}
	
	public Statut updateStatut(Statut st) {
		Statut s = em.find(Statut.class, st.getId());
		s.setNom(st.getNom());
		s.setRelEntity(st.getRelEntity());
		return s;
	}
	
	public Integer deleteStatutByName(String stName) {
		String jpql = "delete from Statut s where s.nom = :paramStName";
		Query qr = em.createQuery(jpql);
		qr.setParameter("paramStName", stName);
		int deletedCount = qr.executeUpdate();
		return deletedCount;
	}
}
