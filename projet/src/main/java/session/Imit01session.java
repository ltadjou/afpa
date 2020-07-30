package session;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import entities.*;

@Component("imit01Session")
@Scope(value= "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Imit01session {
	
	private Departement departTrouve;
	private Compte compteC;
	private List<Categorie> categories;
	private List<Acteur> acteurs;
	private Profil profil;
	
	
	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public Compte getCompteC() {
		return compteC;
	}

	public void setCompteC(Compte compteC) {
		this.compteC = compteC;
	}

	public Departement getDepartTrouve() {
		return departTrouve;
	}

	public void setDepartTrouve(Departement departTrouve) {
		this.departTrouve = departTrouve;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	
	
	
}
