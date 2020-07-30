package repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Compte;
import entities.Profil;
import entities.Statut;
import entities.TypeActeur;
import entities.Ville;

@Repository("compteDao")
@Transactional
public class CompteDaoImpl implements CompteDao  {	
	
	@Autowired
	private EntityManager em;

	public Compte seConnecterCompte(String email, String mdp) {
		String jpql = "select c from Compte c where c.email= :email and c.mdp= :mdp";
		TypedQuery<Compte> qr = em.createQuery(jpql,Compte.class);
		qr.setParameter("email", email);
		qr.setParameter("mdp", mdp);
		Compte compte;
		try {
			compte = qr.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return compte;
	}
	
	@Override
	public Compte insertCompteIndividu(String nom, String prenom, String email, String mdp, String rue,
			String codePostal, String tel, Date dateNaiss, TypeActeur typeActeur,
			Statut statut, Ville ville) {
		Compte c = new Compte(nom, prenom, email, mdp, rue, codePostal, tel, dateNaiss, typeActeur, statut, ville);
		em.persist(c);
		return c;
	}

	@Override
	public Compte insertCompteOrganisation(String nomOrganisation, String email, String mdp, String rue,
			String codePostal, String tel, Date dateCrea, String numSiret, TypeActeur typeActeur, Statut statut,
			Ville ville) {
		Compte c = new Compte(nomOrganisation, email, mdp, rue, codePostal, tel, dateCrea,  numSiret, typeActeur, statut, ville);
		em.persist(c);
		return c;
	}

	@Override
	public Compte selectCompteById(Long idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		return c;
	}

	@Override
	public List<Compte> selectAllCompte() {
		String s01 = "select c from Compte c";
		TypedQuery<Compte> quer = em.createQuery(s01, Compte.class);
		List<Compte>  listC = quer.getResultList();
		return listC;
	}

	@Override 
	public List<Compte> selectAllCompteByDept(Long idDept) {
		String s01 = "select c from Compte c join c.ville v where v.departement.id = :paramsDept ";
		TypedQuery<Compte> quer = em.createQuery(s01, Compte.class);
		quer.setParameter("paramsDept", idDept);
		List<Compte>  listC = quer.getResultList();
		return listC;
	}
 
	@Override
	public List<Compte> selectAllCompteByVille(Long idVille) {
		String s01 = "select c from Compte c where c.ville.id = :paramsDept ";
		TypedQuery<Compte> quer = em.createQuery(s01, Compte.class);
		quer.setParameter("paramsDept", idVille);
		List<Compte>  listC = quer.getResultList();
		return listC;
	}
	
	@Override
	public List<Compte> selectAllCompteActive() {
		String s01 = "select c from Compte c where c.statut.id = 'C001' ";
		TypedQuery<Compte> quer = em.createQuery(s01, Compte.class);
		List<Compte>  listC = quer.getResultList();
		return listC;
	}

	
	@Override
	public Compte updateCompteIndividuById(Long idCompte, String nom, String prenom, String email, String mdp,
			String rue, String codePostal, String tel, Date dateNaiss, Ville ville) {
		Compte c = em.find(Compte.class, idCompte);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setMDP(mdp);
		c.setRue(rue);
		c.setCodePostal(codePostal);
		c.setTel(tel);
		c.setDateNaiss(dateNaiss);
		c.setVille(ville);
		
		return c;
	}
	
	@Override
	public Compte updateCompteOrganisationById(Long idCompte, String nomOrganisation, String email, String mdp,
			String rue, String codePostal, String tel, Date dateCrea, String numSiret, Ville ville) {
		Compte c = em.find(Compte.class, idCompte);
		c.setNomOrganisation(nomOrganisation);
		c.setEmail(email);
		c.setMDP(mdp);
		c.setRue(rue);
		c.setCodePostal(codePostal);
		c.setTel(tel);
		c.setDateCrea(dateCrea);
		c.setNumSiret(numSiret);
		c.setVille(ville);
		return c;
	}

	
	@Override
	public void activationCompteById(Long idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		Statut s = em.find(Statut.class, "C001");
		c.setStatut(s);
	}

	@Override
	public void inactivationCompteById(Long idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		Statut s = em.find(Statut.class, "C002");
		c.setStatut(s);
		
	}

	@Override
	public void deleteCompteById(Long idCompte) {
		Compte c = em.find(Compte.class, idCompte);
		em.remove(c);
		
	}

	

	

	

	
	
}

	