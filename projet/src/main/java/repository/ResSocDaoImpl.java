package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Profil;
import entities.ReseauSocial;

@Repository
@Transactional
public class ResSocDaoImpl implements ResSocDao {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void AssReseauProfil(Long idP, Long idR) {
		ReseauSocial reseau = em.find(ReseauSocial.class, idR);
		Profil profil = em.find(Profil.class, idP);
		reseau.setProfil(profil);
		em.persist(reseau);
	}
	
	public ReseauSocial insertReseauSoc(String nom, String url) {
		ReseauSocial rs = new ReseauSocial(nom, url);
		em.persist(rs);
		return rs;
	}
	
	public ReseauSocial selectReseauSocById(Long idRS) {
		ReseauSocial rs = em.find(ReseauSocial.class, idRS);
		return rs;
	}
	
	public List<ReseauSocial> selectReseauSocByProfilId(Long idProfil){
		String jpql = "select r from ReseauSocial r where a.profil.id = :paramId";
		TypedQuery<ReseauSocial> qr = em.createQuery(jpql, ReseauSocial.class);
		qr.setParameter("paramId", idProfil);
		List<ReseauSocial> result = qr.getResultList();
		return result;
	}
	
	public ReseauSocial updateReseauSoc(ReseauSocial rss) {
		ReseauSocial rs = em.find(ReseauSocial.class, rss.getId());
		rs.setNom(rss.getNom());
		rs.setUrl(rss.getUrl());
		return rs;
	}
	
	public Integer deleteReseauSocById(ReseauSocial rss) {
		Long idRS = rss.getId();
		String jpql = "delete from ReseauSocial r where  r.id = :paramId";
		Query qr = em.createQuery(jpql);
		qr.setParameter("paramId", idRS);
		int deletedCount = qr.executeUpdate();
		return deletedCount;
		}
}
