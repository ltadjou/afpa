package repository;

import javax.persistence.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.*;

@Repository
@Transactional
public class CentreDAOService {
	
	@Autowired
	private EntityManager em;
	
	public void AssServiceProfil(Long idP, Long idS) {
		entities.Service service = em.find(entities.Service.class, idS);
		Profil profil = em.find(Profil.class, idP);
		service.getProfils().add(profil);
	}
	
	public Service insertService(String nom, String description, Acteur acteur) {
		Service s = new Service(nom, description, acteur);
		em.persist(s);
		return s ;
}
	
	public Service selectServiceById(Long idServ) {
		Service serv = em.find(Service.class, idServ);
		return serv;
	}
	
	
	public List<Service> findAllServices() {
		String jpql ="select * from Service s ";
		TypedQuery<Service> qr = em.createQuery(jpql,Service.class);
		List<Service> result = qr.getResultList();
		return result;
	}
}
