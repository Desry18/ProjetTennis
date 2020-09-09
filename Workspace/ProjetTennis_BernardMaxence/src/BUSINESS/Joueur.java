package BUSINESS;

import java.io.Serializable;

public class Joueur implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917513929716926642L;
	private int Id; 
	private String Nom;
	private String Sexe;
	
	public Joueur() {
		
	}
	
	
	public Joueur(int id, String nom, String sexe) {
		super();
		Id = id;
		Nom = nom;
		Sexe = sexe;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getSexe() {
		return Sexe;
	}
	public void setSexe(String sexe) {
		Sexe = sexe;
	}
	
}
