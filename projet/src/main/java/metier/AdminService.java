package metier;

import java.util.List;

import entities.Administrateur;
import entities.Statut;

public interface AdminService {
	public Administrateur identifyAdmin(String idtf, String mdp);
	public Boolean authentifierAdmin(String idtf, String mdp);
	public List<Administrateur> extractAllAdmin();
	public Statut checkStatut(String idSt);
	public Administrateur creerAdmin(Administrateur admin);
	public Administrateur checkNum(String num);
	public Administrateur selectAdmin(String idAdmin);
	public Administrateur updateAdmin(Administrateur admin);
	
}
