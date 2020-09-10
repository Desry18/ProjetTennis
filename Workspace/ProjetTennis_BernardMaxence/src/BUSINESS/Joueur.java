package BUSINESS;

import java.io.Serializable;

public class Joueur extends Personne implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5917513929716926642L;

	public Joueur() {
		
	}
	
	
	public Joueur(int id, String nom, String sexe) {
		super(id, nom, sexe);
	}
	
}
