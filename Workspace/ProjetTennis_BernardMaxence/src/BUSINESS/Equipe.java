package BUSINESS;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private Joueur joueurA = new Joueur();
	private Joueur joueurB = new Joueur();
	
	public Equipe(){
		
	}
	
	
	public Equipe(Joueur joueurA) {
		super();
		this.joueurA = joueurA;
	}
	public Equipe(Joueur joueurA, Joueur joueurB) {
		super();
		this.joueurA = joueurA;
		this.joueurB = joueurB;
	}
	public Joueur getJoueurA() {
		return joueurA;
	}
	public void setJoueurA(Joueur joueurA) {
		this.joueurA = joueurA;
	}
	public Joueur getJoueurB() {
		return joueurB;
	}
	public void setJoueurB(Joueur joueurB) {
		this.joueurB = joueurB;
	}
	

	
	
}
