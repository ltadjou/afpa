package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import entities.Departement;
import entities.Ville;
import repository.VilleDao;

@Service("villeMetier")
public class VilleMetierImpl implements VilleMetier {

	@Autowired
	@Qualifier("villeDao")
	private VilleDao villeDao;
	
	@Override
	public Ville creationVille(String nom, Departement departement) {
		Ville v01 = villeDao.insertVille(nom, departement);
		return v01;
	}

	@Override
	public Ville affichageVilleId(Long idVille) {
		Ville v02 = villeDao.selectVilleById(idVille);
		return v02;
	}

	@Override
	public List<Ville> affichageVilleDept(Long idDept) {
		List<Ville> listv = villeDao.selectAllVilleDept(idDept);
		return listv;
	}

	@Override
	public Ville majVilleId(Long idVille, String nom, Long idDept) {
		Ville v03 = villeDao.updateVilleById(idVille, nom, idDept);
		return v03;
	}

	@Override
	public void suppressionVilleId(Long idVille) {
		villeDao.deleteVilleById(idVille);
		
	}

}
