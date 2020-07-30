package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import entities.Pays;
import repository.PaysRepository;

@Service("paysMetier")
public class PaysMetierImpl {
	
	@Autowired
	@Qualifier("paysRep")
	private PaysRepository paysRep;

	public List<Pays> findAll() {
		List<Pays> listPays= paysRep.findAll();
		return listPays;
	}

}
