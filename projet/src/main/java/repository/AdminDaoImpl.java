package repository;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Administrateur;
import entities.Profil;
import entities.Statut;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private EntityManager em;
	
	@Override
	public void AssAdminProfil(Long idP, Long idA){
		Administrateur admin = em.find(Administrateur.class, idA);
		Profil profil = em.find(Profil.class, idP);
		admin.getProfils().add(profil);
	}
	
	public Administrateur insertAdmin(String idtf, String mdp, String nom, String prenom, String numEmp,
			Date dateIn, Statut st) {
		Administrateur admin = new Administrateur(idtf, mdp, nom, prenom, numEmp, dateIn, st);
		em.persist(admin);
		return admin;
	}
	
	public Administrateur selectAdminById(Long idAdmin) {
		Administrateur admin = em.find(Administrateur.class, idAdmin);
		return admin;
	}
	
	public List<Administrateur> selectAllAdmin(){
		String jpql = "select a from Administrateur a";
		TypedQuery<Administrateur> qr = em.createQuery(jpql, Administrateur.class);
		List<Administrateur> result = qr.getResultList();
		return result;
	}
	
	public Administrateur updateAdmin(Administrateur ad) {
		Administrateur a = em.find(Administrateur.class, ad.getId());
		a.setIdentifiant(ad.getIdentifiant());
		a.setMdp(ad.getMdp());
		a.setNom(ad.getNom());
		a.setPrenom(ad.getPrenom());
		a.setNumEmploye(ad.getNumEmploye());
		a.setDateEntree(ad.getDateEntree());
		a.setDateSortie(ad.getDateSortie());
		a.setStatut(ad.getStatut());
		return a;
	}
	
	
	public Integer deleteAdminById(Long idAdmin) {
		String jpql = "delete from Administrateur a where a.id = :paramIdAdmin";
		Query qr = em.createQuery(jpql);
		qr.setParameter("paramIdAdmin", idAdmin);
		int deletedCount = qr.executeUpdate();
		return deletedCount;
	}

	public Administrateur verifyAdmin(String idtf, String mdp) {
		String jpql = "select a from Administrateur a where a.identifiant = :paramIdtf";
		TypedQuery<Administrateur> qr = em.createQuery(jpql, Administrateur.class);
		qr.setParameter("paramIdtf", idtf);
		Administrateur a;
		try {
				a = qr.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		if(a!=null) {
			if (a.getMdp().equals(mdp)) {
				return a;
			} 		
		}
		return null;
	}
	
	public Boolean findAdmin(String idtf, String mdp) {
		String jpql = "select a from Administrateur a where a.identifiant = :paramIdtf";
		TypedQuery<Administrateur> qr = em.createQuery(jpql, Administrateur.class);
		qr.setParameter("paramIdtf", idtf);
		Administrateur a;
		try {
				a = qr.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		
		if(a!=null) {
			if (a.getMdp().equals(mdp)) {
				return true;
			} 		
		}
		return false;
		}

	@Override
	public Administrateur creerAdmin(Administrateur admin) {
		em.persist(admin);
		return admin;
	}

	@Override
	public Administrateur checkNum(String num) {
		String jpql = "select a from Administrateur a where a.numEmploye = :paramNum";
		Query qr = em.createQuery(jpql, Administrateur.class);
		qr.setParameter("paramNum", num);
		
		return null;
	}

	
}
	
