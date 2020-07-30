package com.ACTOREP.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entities.*;
import metier.*;
import repository.*;

import org.springframework.context.annotation.*;



@ComponentScan(basePackages = {"repository","controller","metier","session"})
@EntityScan(basePackages = {"entities"})
@EnableJpaRepositories(basePackageClasses = {IDepartementRepository.class , IProfilRepository.class})
@SpringBootApplication(scanBasePackages="com.ACTOREP.*")
@EnableConfigurationProperties
public class ProjetApplicationMain {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplicationMain.class, args);
	}

@Autowired
EntityManager em;
	
@Autowired
AdminDaoImpl amd;

@Autowired
PaysRepository paysRep;

@Autowired
IDepartementRepository deptRep;

@Autowired
StatutDaoImpl std;
	
@Autowired
ResSocDaoImpl rsd;

@Autowired
VilleDao villeDao;

@Autowired
TypeActeurDao TypeActeurDao;

@Autowired
CompteDao compteDao;

@Autowired
CentreDAOCategorie centreDAOCategorie;

@Autowired
CentreDAOActeur centreDAOActeur;

@Autowired
CentreDAOService centreDAOService;

@Autowired
ProfilMetierImpl profilMet;

@Autowired
DepartementMetierImpl deparMet;
	
@Bean
CommandLineRunner myMain() {
	return args -> {
		

//	Statut st01 = std.insertStatut("A001", "Activer l'administrateur", "Administrateur");


		System.out.println(" <<<<<<<<<<< dans le Main");
	
//		Administrateur ad01 = amd.insertAdmin("dtan", "123456", "Tan", "Dany", "A00001", new Date());
//		Administrateur ad02 = amd.insertAdmin("ikakou", "123456", "Kakou", "Ingrid", "A00002", new Date());
//		Administrateur ad03 = amd.insertAdmin("nboumediene", "123456", "Boumediene", "Nawel", "A00003", new Date());
//		Administrateur ad04 = amd.insertAdmin("anaudin", "123456", "Naudin", "Alexandre", "A00004", new Date());

		Statut st01 = std.insertStatut("A001", "Activer l'administrateur", "Administrateur");
		Statut st02 = std.insertStatut("A002", "Désactiver l'administrateur", "Administrateur");
		Statut st03 = std.insertStatut("P001", "Activer le profil", "Profil");
		Statut st04 = std.insertStatut("P002", "Désactiver le profil", "Profil");
		Statut st05 = std.insertStatut("P003", "Profil en cours de validation", "Profil");
		Statut st06 = std.insertStatut("P004", "Profil bloqué par l'administrateur", "Profil");
		Statut st07 = std.insertStatut("C001", "Activer le compte", "Compte");
		Statut st08 = std.insertStatut("C002", "Désactiver le compte", "Compte");

		Administrateur ad01 = amd.insertAdmin("dtan", "123456", "Tan", "Dany", "A00001", new Date(), st01);
		Administrateur ad02 = amd.insertAdmin("ikakou", "123456", "Kakou", "Ingrid", "A00002", new Date(), st01);
		Administrateur ad03 = amd.insertAdmin("nboumediene", "123456", "Boumediene", "Nawel", "A00003", new Date(), st01);
		Administrateur ad04 = amd.insertAdmin("anaudin", "123456", "Naudin", "Alexandre", "A00004", new Date(), st01);
		
		ReseauSocial rs01 = rsd.insertReseauSoc("Youtube", "aaaaaaaa");
		ReseauSocial rs02 = rsd.insertReseauSoc("LinkedIn", "bbbbbbbb");
		
		Departement dept01 = new Departement(75L);
		Departement dept02 = new Departement(92L);
		Departement dept03 = new Departement(95L);
		Ville v01 = villeDao.insertVille("Paris", dept01);
		Ville v02 = villeDao.insertVille("Clichy", dept02);
		Ville v03 = villeDao.insertVille("Cergy", dept03);
		
		TypeActeur ta01 = TypeActeurDao.insertTypeActeur("Personne", "personne réelle");
		TypeActeur ta02 = TypeActeurDao.insertTypeActeur("Organise", "société");
		
		Date dt01 = new Date();
		Date dt02 = new Date(1986, 11, 23);
		compteDao.insertCompteIndividu("Pitt", "Brad", "brad.pitt@gmail.com", "bpitt", "12 rue joli", "75005", "333333", dt01, ta01, st07, v01);
		compteDao.insertCompteIndividu("Kakou", "Alban", "kakou.alban@hotmail.com", "kalb", "70 rue du javelot", "75013", "5555", dt02, ta02, st08, v02);
		compteDao.insertCompteOrganisation("MSF", "msf@orga.fr", "msf", "9 rue des medecins", "69001", "8888", dt02, "rsc555", ta02, st07, v01);
		compteDao.insertCompteOrganisation("HJH", "HJH@hotmail.fr", "HJH", "13 rue pinedes", "75009", "22222", dt01, "sts999", ta01, st08, v02);
		
		
	
		Categorie ca1 = centreDAOCategorie.insertCategorie("Santé","Tout les professionnels de santé");
		Categorie ca2 = centreDAOCategorie.insertCategorie("Sport","Tout les professionnels Sportif ");
		Categorie ca3 = centreDAOCategorie.insertCategorie("Consulting","");
		Categorie ca4 = centreDAOCategorie.insertCategorie("Informatique","");
		

		Acteur ac1 = centreDAOActeur.insertActeur( "Kinésithérapeute "," ", ca1);
		Acteur ac2 = centreDAOActeur.insertActeur("Infirmier ", " ", ca1);
		Acteur ac3 = centreDAOActeur.insertActeur("Coach Sportif "," ", ca2);
		Acteur ac4 = centreDAOActeur.insertActeur("Danseur"," ", ca2);
		Acteur ac5 = centreDAOActeur.insertActeur("Négociation "," ", ca3);
		Acteur ac6 = centreDAOActeur.insertActeur("Marketing"," ", ca3);
		Acteur ac7 = centreDAOActeur.insertActeur("Developpeur ","Java et Javascript ", ca4);
		Acteur ac8 = centreDAOActeur.insertActeur("IUX Designer "," ", ca4);

		
		Service s1 = centreDAOService.insertService("Consultation", " ", ac1);
		Service s2 = centreDAOService.insertService("Consultation à domicile", "", ac1);
		Service s3 = centreDAOService.insertService("Consultation à domicile", "", ac2);
		Service s4 = centreDAOService.insertService("Consultation à domicile le week-end","", ac2);
		Service s5 = centreDAOService.insertService("A domicile", "", ac3);
		Service s6 = centreDAOService.insertService("Cours en groupe", "", ac3);
		Service s7 = centreDAOService.insertService("Cours individuel", "", ac4);
		Service s8 = centreDAOService.insertService("Spectacle", "", ac4);
		Service s9 = centreDAOService.insertService("Stage en groupe", "apprendre à négocier", ac5); 
		Service s10 = centreDAOService.insertService("Cours individuel", "apprendre à négocier", ac5);
		Service s11 = centreDAOService.insertService("Stratégie publicitaire", "quelle stratégie adoptée pour votre entreprise", ac6); 
		Service s12 = centreDAOService.insertService("Stratégie lancement site internet", "comment déployer votre site", ac6);
		Service s13 = centreDAOService.insertService("Développement application", "développer une nouvelle application", ac7); 
		Service s14 = centreDAOService.insertService("Support débogage", "maintenance sur une application", ac7);
		Service s15 = centreDAOService.insertService("Conseil site internet", "", ac8); 
		Service s16 = centreDAOService.insertService("Conception site internet", "", ac8);
		
		Compte com1 = compteDao.selectCompteById(1l);
		Compte com2 = compteDao.selectCompteById(2l);
		Compte com3 = compteDao.selectCompteById(3l);
		Compte com4 = compteDao.selectCompteById(4l);
		
		Profil pro1= profilMet.addProfil("je me presente1", "image/Brad-Pitt.jpg", "j'offre1", com1);
		Profil pro2= profilMet.addProfil("je me presente2", null, "j'offre2", com2);
		Profil pro3= profilMet.addProfil("je me presente3", null, "j'offre3", com3);
		Profil pro4= profilMet.addProfil("je me presente4", null, "j'offre4", com4);
		
		rsd.AssReseauProfil(1L, 1L);
		rsd.AssReseauProfil(1L, 2L);
		
		amd.AssAdminProfil(1l, 1l);
		amd.AssAdminProfil(1l, 2l);
		amd.AssAdminProfil(2l, 1l);
		amd.AssAdminProfil(2l, 3l);
		amd.AssAdminProfil(4l, 4l);
		amd.AssAdminProfil(3l, 2l);
		amd.AssAdminProfil(3l, 3l);
		amd.AssAdminProfil(1l, 4l);
		
		centreDAOService.AssServiceProfil(1l, 1l);
		centreDAOService.AssServiceProfil(1l, 2l);
		centreDAOService.AssServiceProfil(1l, 3l);
		centreDAOService.AssServiceProfil(1l, 4l);
		centreDAOService.AssServiceProfil(2l, 4l);
		centreDAOService.AssServiceProfil(2l, 6l);
		centreDAOService.AssServiceProfil(3l, 4l);
		centreDAOService.AssServiceProfil(3l, 1l);
		centreDAOService.AssServiceProfil(4l, 5l);
		centreDAOService.AssServiceProfil(4l, 6l);


		
		System.out.println(" <<<<<<<<<<< FIN >>>>>>>>>>>>");
		
		String nomActeur = "Kinésithérapeute ";
		String rqt="select s.profils from Service s where s.acteur.nom= :paramActeur";
		Query qr = em.createQuery(rqt);
		qr.setParameter("paramActeur", nomActeur);
		List<Profil> profils = qr.getResultList();
		
		/*String nomDepart="Paris";
		String rqts="select c.profils from Compte c join c.ville v join c.ville.departement d where d.nom = :nomDepart";
		Query qry = em.createQuery(rqts);
		qry.setParameter("nomDepart", nomDepart);
		List<Profil> profils1 = qry.getResultList();
		for(Profil p : profils1) {
			System.out.println("p = "+p);*/
		

		};
	}
	
}

