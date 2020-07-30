package repository;

import java.util.List;

import entities.ReseauSocial;

public interface ResSocDao {
	public ReseauSocial insertReseauSoc(String nom, String url);
	public ReseauSocial selectReseauSocById(Long idRS);
	public List<ReseauSocial> selectReseauSocByProfilId(Long idProfil);
	public ReseauSocial updateReseauSoc(ReseauSocial rss);
	public void AssReseauProfil(Long idP, Long idR);
	public Integer deleteReseauSocById(ReseauSocial rss);
}
