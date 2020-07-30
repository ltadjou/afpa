package repository;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.*;


@Repository
@Transactional
public class CentreDAOActeur {
	
	@Autowired
	private EntityManager em;
	
	
	public Acteur insertActeur (String nom, String description, Categorie categorie) {
		Acteur a = new Acteur(nom,description, categorie);
		em.persist(a);
		return a;
	}
	
	public Acteur getActeur (Long id) {
		Acteur actor = em.find(Acteur.class, id);
		return actor;
	}
	
	
	
	public List<Acteur> selectAllActeurs() {
		String jpql ="select a from Acteur a";
		TypedQuery<Acteur> qr = em.createQuery(jpql,Acteur.class);
		List<Acteur> result = qr.getResultList();
		return result;
	}
	
}
