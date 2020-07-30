package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import entities.TypeActeur;
import repository.TypeActeurDao;

@Service("typeActeurMetier")
public class TypeActeurMetierImpl implements TypeActeurMetier{
	
	@Autowired
	@Qualifier("typeActeurDao")
	private TypeActeurDao typeActeurDao;

	@Override
	public TypeActeur creationTypeActeur(String nom, String description) {
		TypeActeur ta01 = new TypeActeur();
		if (nom == null) {
			return null;
		} else {
			ta01 = typeActeurDao.insertTypeActeur(nom, description);
		}
		
		return ta01;
	}

	@Override
	public TypeActeur affichageTypeActeurId(Long idType) {
		TypeActeur ta02 = typeActeurDao.selectTypeActeurById(idType);
		return ta02;
	}

	@Override
	public List<TypeActeur> affichageToutTypeActeur() {
		List<TypeActeur> liste = typeActeurDao.selectTypeActeur();
		return liste;
	}

	@Override
	public TypeActeur majTypeActeur(Long id, String nom, String description) {
		TypeActeur ta03 = typeActeurDao.updateTypeActeurById(id, nom, description);
		return ta03;
	}

	@Override
	public void suppressionTypeActeurId(Long idType) {
		typeActeurDao.deleteTypeActeurById(idType);
		
	}

	
	
	

	
	
}
