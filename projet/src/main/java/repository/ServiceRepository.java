package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entities.Acteur;
import entities.Service;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
	
	
	@Query("select xx from Service xx where xx.acteur = ?1")
	List<Service> findAllByIdActor(Acteur actor);
	
	
}
