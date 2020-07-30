package metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import entities.Administrateur;
import entities.Statut;
import repository.AdminDao;
import repository.StatutDao;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	@Qualifier("adminDao")
	private AdminDao adminDao;
	
	@Autowired
	@Qualifier("statutDao")
	private StatutDao statutDao;
	
	@Override
	public Administrateur identifyAdmin(String idtf, String mdp) {
		Administrateur ad = adminDao.verifyAdmin(idtf, mdp);
		if(ad != null) {
			return ad;
		}
		return null;
	}
	
	@Override
	public Boolean authentifierAdmin(String idtf, String mdp) {
		Boolean trouve = adminDao.findAdmin(idtf, mdp);
		return trouve;
	}

	@Override
	public List<Administrateur> extractAllAdmin() {
		List<Administrateur> allAd = adminDao.selectAllAdmin();
		return allAd;
	}

	@Override
	public Statut checkStatut(String idSt) {
		Statut s = statutDao.selectStatutById(idSt);
		return s;
	}

	@Override
	public Administrateur creerAdmin(Administrateur admin) {
		Administrateur ad = adminDao.creerAdmin(admin);
		return ad;
	}

	@Override
	public Administrateur checkNum(String num) {
		Boolean newNum;
		return null;
	}

	@Override
	public Administrateur selectAdmin(String idAdmin) {
		Long id = Long.valueOf(idAdmin);
		Administrateur ad = adminDao.selectAdminById(id);
		return ad;
	}

	@Override
	public Administrateur updateAdmin(Administrateur admin) {
		Administrateur ad = adminDao.updateAdmin(admin);
		return ad;
	}

	

}
