package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import entities.Pays;

@Repository("paysRep")
@Transactional
public interface PaysRepository extends JpaRepository<Pays, Long> {

}
