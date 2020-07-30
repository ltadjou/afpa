package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import entities.Departement;
import repository.IDepartementRepository;

@Service("departementMetier")
public class DepartementMetierImpl {
	
	@Autowired
	@Qualifier("departementRep")
	private IDepartementRepository departementRep;
	
	public List<Departement> findDepartementByPays(String nom){
		List<Departement> listDeparts= departementRep.findDepartementByPays(nom);
		return listDeparts;
	}
	
	public Departement findDepartementByCodeOrNom(String search) {
		Departement depart = departementRep.findDepartementByCodeOrNom(search);
		
		return depart;
	}

	
}
