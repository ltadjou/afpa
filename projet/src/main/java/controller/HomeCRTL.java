package controller;





import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import metier.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entities.Acteur;
import entities.Categorie;
import entities.Compte;
import entities.Departement;
import entities.Profil;
import entities.Service;
import metier.DepartementMetierImpl;
import metier.ProfilMetierImpl;
import repository.CentreDAOActeur;
import repository.CentreDAOCategorie;
import repository.CompteDaoImpl;
import repository.ServiceRepository;
import repository.TypeActeurDaoImpl;
import session.Imit01session;

@Controller
public class HomeCRTL {
	
	public HomeCRTL() {
	}

	@Autowired
	CompteDaoImpl compteImpl;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	ProfilMetierImpl profilMet;
	
	@Autowired
	DepartementMetierImpl deparMet;
	
	@Autowired
	private Imit01session session01;
	
	@Autowired
	CentreDAOCategorie centreDAOCategorie;
	
	@Autowired
	CentreDAOActeur centreDAOActeur;
	
	
	
	@RequestMapping(value = {"/","/index"})
	public String afficheAccueil(Model model) {
		java.util.List<Categorie> categories = centreDAOCategorie.selectAllCategories();
		session01.setCategories(categories);
		
		java.util.List<Acteur> acteurs = centreDAOActeur.selectAllActeurs();
		session01.setActeurs(acteurs);
	
		return "frontOffice/jsp/jspHome";
	}
	
	@RequestMapping(value= "/rechercher")
	public String rechercher(@RequestParam(value="dept") String dept, Model model) {
		
		java.util.List<Profil> profils = profilMet.findProfilHome("Kinésithérapeute");
		model.addAttribute("profils", profils);

		
		return "frontOffice/jsp/jspResultatR";
	}
	
	@RequestMapping(value= "/seConnecter")
	public String seConnecter(@RequestParam  HashMap<String, String> params, Model model) {
		
		String email = params.get("email");
		String mdp = params.get("mdp");	
		Compte compte = compteImpl.seConnecterCompte(email, mdp);
		if(compte!=null) {
			session01.setCompteC(compte);
			model.addAttribute("nom", compte.getNom());
			model.addAttribute("prenom", compte.getPrenom());
			model.addAttribute("tel", compte.getTel());
			model.addAttribute("mail", compte.getEmail());
			model.addAttribute("ville", compte.getVille().getNom());
			
			Profil profil = profilMet.findProfilByIdCompte(compte.getId());
			session01.setProfil(profil);
			model.addAttribute("pres", profil.getPresentation());
			model.addAttribute("offre", profil.getOffre());
			model.addAttribute("photop", profil.getPhotoProfil());
			
			java.util.List<Service> list = profilMet.findServiceByIdProfil(profil.getId());
				model.addAttribute("services", list);
			
			model.addAttribute("acteur", list.get(0).getActeur().getNom());
			
			return "frontOffice/jsp/jspProfil";
		}else {
			model.addAttribute("error1","Email/mot de passe incorrect");
			return "frontOffice/jsp/jspConnexion";
		}
	}
	
	@RequestMapping(value= "/vers-jspHome")
	public String afficherHome() {
		return "frontOffice/jsp/jspHome";
	}
	
	@RequestMapping(value = {"/vers-jspInscription"})
	public String afficheInscription( Model model) {
		
		
		List<Categorie> listC = centreDAOCategorie.selectAllCategories();
		model.addAttribute("categories", listC);
		
		List<Departement> listD = deparMet.findDepartementByPays("France");
		model.addAttribute("depts", listD);
		
		List<Acteur> listA = centreDAOActeur.selectAllActeurs();
		model.addAttribute("acteurs", listA);
		
		return "frontOffice/jsp/jspInscription";
	}
	
	@RequestMapping(value = {"/vers-jspConnexion"})
	public String afficheConnexion() {
		return "frontOffice/jsp/jspConnexion";
	}
	
	@RequestMapping(value = {"/vers-jspContact"})
	public String afficheContact() {
		return "frontOffice/jsp/jspContact";
	}
	
	@RequestMapping(value = {"/vers-jspQuiSommesNous"})
	public String afficheQuiSommesNous() {
		return "frontOffice/jsp/jspQuiSommesNous";
	}
	
	
	@RequestMapping(value = {"/vers-jspCommentCaMarche"})
	public String afficheCommentCaMarche() {
		return "frontOffice/jsp/jspCommentCaMarche";
	}
	
	
	@RequestMapping(value = {"/services_acteur/{idActeur}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Service> getServicesByActors(@PathVariable Long idActeur) {
		List<Service>  result = serviceRepository.findAllByIdActor(centreDAOActeur.getActeur(idActeur));
		//List<Service>  result = serviceRepository.findAllByIdActor(idActeur);
		System.out.print(result.size());
		return  result;
	}

	

	@RequestMapping(value= "/recherche")
	public String rechercher() {
		return "backOffice/jspResultatR";
	}
	
	@RequestMapping(value= {"/RechercherProfilaValider"})
	public String afficheProfilaValider(Model model) {
	List<Profil> listp = profilMet.findProfilAValider();
	System.out.print(listp.size() + "kjsdfjsldkjflksjdlfskdjflksdjflksjfljsdlf");
		 model.addAttribute("listp", listp);
		return "backOffice/Accueil";
	}
	
	@RequestMapping(value= {"/registration"})
	public String registration(Model model) {
	
	
		//return "frontOffice/jsp/jspConnexion";
		 return afficheConnexion();
	}

	}



