package repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import entities.Departement;

@Repository("departementRep")
@Transactional
public interface IDepartementRepository extends JpaRepository<Departement, Long> {

	@Query("select d from Departement d where d.pays.nomFrFr = :x")
	public List<Departement> findDepartementByPays(@Param("x")String nom);
	
	@Query("select d from Departement d where d.nom = :x or d.code = :x")
	public Departement findDepartementByCodeOrNom(@Param("x")String search);


}
