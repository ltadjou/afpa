package repository;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.*;

@Repository("profilRep")
@Transactional
public interface IProfilRepository extends JpaRepository<Profil, Long> {
	
	@Query("select p.services from Profil p where p.id = :x") 
	public List<Service> findServicesByProfil(@Param("x")Long id);
	
	@Query("select p.reseaux from Profil p where p.id = :x") 
	public List<ReseauSocial> findReseauxByProfil(@Param("x")Long id);
	
	@Query("select p from Profil p where p.statut.id = :x")
	public List<Profil> findProfilByIdStatus(@Param("x")String id);
	

	@Query("select p from Profil p where p.compte.id = :x")
	public Profil findProfilByIdCompte(@Param("x")Long idCompte);
	

	@Query("select s.profils from Service s where s.acteur.nom= :y")
	public List<Profil> findProfilHome( @Param("y")String search);

}
