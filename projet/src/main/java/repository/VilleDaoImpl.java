package repository;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.*;


@Repository ("villeDao")
@Transactional
public class VilleDaoImpl implements VilleDao {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public Ville insertVille (String nom, Departement departement) {
		Ville v = new Ville (nom);
		v.setDepartement(departement);
		em.persist(v);
		return v ;
	}

	@Override
	public Ville selectVilleById(Long idVille) {
		Ville v = em.find(Ville.class, idVille);
		return v;
	}

	@Override
	public List<Ville> selectAllVilleDept(Long idDept) {
		String jpql = "select v from Ville v where v.departement.id = :paramsDept";
		TypedQuery<Ville> qr = em.createQuery(jpql, Ville.class);
		qr.setParameter("paramsDept", idDept);
		List<Ville> result = qr.getResultList();
		return result;
	}

	@Override
	public Ville updateVilleById(Long idVille, String nom, Long idDept) {
		Ville v = em.find(Ville.class, idVille);
		v.setNom(nom);
		Departement d = em.find(Departement.class, idDept);
		v.setDepartement(d);
		return v;
		
	}

	@Override
	public void deleteVilleById(Long idVille) {
		Ville v = em.find(Ville.class, idVille);
		em.remove(v);
		
	}
	
	

}
