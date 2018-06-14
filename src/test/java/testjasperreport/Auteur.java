package testjasperreport;

import java.util.ArrayList;
import java.util.List;

public class Auteur {

	private String nom;
	private String prenom;
	private Integer age;
	private List < Livre > livres = new ArrayList <>();

	public Auteur(final String prenom, final String nom, final Integer age) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	public void ajouteLivre(final String titre, final Integer note) {
		Livre aux = new Livre();
		aux.setTitre(titre);
		aux.setNote(note);
		getLivres().add(aux);
	}

	public List < Livre > getLivres() {
		return livres;
	}

	public void setLivres(List < Livre > livres) {
		this.livres = livres;
	}

}
