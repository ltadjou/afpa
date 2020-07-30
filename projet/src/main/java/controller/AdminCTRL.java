package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Administrateur;
import entities.Statut;
import metier.AdminService;
import session.SessionAdmin;

@Controller
public class AdminCTRL {

	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	@Autowired
	private SessionAdmin sessionAdmin;
	
	@RequestMapping(value = {"/back"})
	public String afficherFenetreConnexion() {
		return "backOffice/connexion";
	}
	
	@RequestMapping(value = {"/authentification"})
	public String authentifierAdmin(@RequestParam HashMap<String, String> params, Model model) {
		String idtf = params.get("idtf");
		String pwd = params.get("pwd");
		model.addAttribute("idtf", idtf);
		
		if(idtf.isEmpty() || pwd.isEmpty()) {
			model.addAttribute("err", "Tous les champs sont obligatoires !");
			return "backOffice/connexion";
		}
		
		Administrateur adm = adminService.identifyAdmin(idtf, pwd);
		if(adm != null) {
			sessionAdmin.setLastLogIn(adm);
			return "backOffice/template";
		} else 
			model.addAttribute("err", "Identifiant / mot de passe incorrect(s) !");
			return "backOffice/connexion";	
	}
	
	@RequestMapping(value = {"/deconnecter"})
		public String seDeconnecter() {
			return "backOffice/connexion";
		}
	
	
	@RequestMapping(value = {"/droitsAd"})
	public String gererAdministrateur(Model model) {
		List<Administrateur> admins = adminService.extractAllAdmin();
		model.addAttribute("admins", admins);
		return "backOffice/droitsAdmin";
	}
	
	@RequestMapping(value = {"/majListAd"})
	public String extraireListAdmin(Model model) {
		List<Administrateur> admins = adminService.extractAllAdmin();
		model.addAttribute("admins", admins);
		model.addAttribute("msg", "La liste est à jour !");
		return "backOffice/droitsAdmin";
	}
	
	@RequestMapping(value = {"/nvlAd"})
		public String afficherFiche() {
			return "backOffice/nvlAdmin";
		}
	
	@RequestMapping(value = {"/creerAd"})
	public String creerAdministrateur(@RequestParam HashMap<String, String> params, Model model) {
		String prenom = params.get("prenomAd");
		String nom = params.get("nomAd");
		String mdp = params.get("mdpAd");
		String num = params.get("numAd");
		String dateEnt = params.get("dateEnt");
		String statut = params.get("optradio");
		
		model.addAttribute("prenomAd", prenom);
		model.addAttribute("nomAd", nom);
		model.addAttribute("mdpAd", mdp);
		model.addAttribute("numAd", num);
		
		if(prenom.isEmpty() || nom.isEmpty() || mdp.isEmpty() || num.isEmpty() || dateEnt.isEmpty()) {
			model.addAttribute("err", "Merci de remplir tous les champs obligatoires !");
			return "backOffice/nvlAdmin";
		}
		
		if(num.length() != 6) {
			model.addAttribute("errNum", "Le numéro employé est composé de 6 caracteres !");
			return "backOffice/nvlAdmin";
		}
		
		//Boolean newNum = 

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		
		Statut st = adminService.checkStatut(statut);
		if(st != null && num.length() == 6) {
			String idtf = prenom.toLowerCase().charAt(0) + nom.toLowerCase();
			Date d = null;
			try {
				d = sdf.parse(dateEnt);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			Administrateur ad = new Administrateur(idtf, mdp, nom, prenom, num, d, st);
			ad = adminService.creerAdmin(ad);
			model.addAttribute("idAd", ad.getId());
			model.addAttribute("prenomAd", ad.getPrenom());
			model.addAttribute("nomAd", ad.getNom());
			model.addAttribute("idtf", ad.getIdentifiant());
			model.addAttribute("mdpAd", ad.getMdp());
			model.addAttribute("numAd", ad.getNumEmploye());
			Date dtEnt = ad.getDateEntree();			
			SimpleDateFormat sdf02 = new SimpleDateFormat("yyyy-MM-dd");
			sdf02.setLenient(false);
			
			model.addAttribute("dateEnt", sdf02.format(dtEnt));
			System.out.println(sdf02.format(dtEnt));
			model.addAttribute("actif",ad.getActif());
	
		}
		
		if(st == null) {
			 model.addAttribute("err", "La création de l'administrateur a échoué");
			 return "backOffice/nvlAdmin";
		 }
		
		List<Administrateur> admins = adminService.extractAllAdmin();
		model.addAttribute("admins", admins);
		return "backOffice/nvlAdmin";
	}
	
	@RequestMapping(value = {"ficheAd"})
	public String afficherFicheAdmin(@RequestParam HashMap<String, String> params, Model model) {
		String idAdmin = params.get("idA");
		Administrateur ad = adminService.selectAdmin(idAdmin);
		model.addAttribute("idAd", ad.getId());
		model.addAttribute("prenomAd", ad.getPrenom());
		model.addAttribute("nomAd", ad.getNom());
		model.addAttribute("idtf", ad.getIdentifiant());
		model.addAttribute("mdpAd", ad.getMdp());
		model.addAttribute("numAd", ad.getNumEmploye());
		Date dtEnt = ad.getDateEntree();			
		SimpleDateFormat sdf02 = new SimpleDateFormat("yyyy-MM-dd");
		sdf02.setLenient(false);	
		model.addAttribute("dateEnt", sdf02.format(dtEnt));
		System.out.println(sdf02.format(dtEnt));
		model.addAttribute("actif",ad.getActif());		
		return "backOffice/ficheAdmin";
	}
	


}
