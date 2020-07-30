package repository;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.*;
@Repository
@Transactional
public class CentreDAOCategorie {

	
	@Autowired
	private EntityManager em;
	
	public Categorie insertCategorie (String nom, String description) {
		Categorie c = new Categorie(nom,description);
		em.persist(c);
		return c;
	}
	
	public List<Categorie> selectAllCategories() {
		String jpql ="select c from Categorie c";
		TypedQuery<Categorie> qr = em.createQuery(jpql,Categorie.class);
		List<Categorie> result = qr.getResultList();
		return result;
	}
	

}
