package BUSINESS;

public class Personne {

	private int Id; 
	private String Nom;
	private String Sexe;
	
	public Personne() {
		
	}
	
	
	public Personne(int id, String nom, String sexe) {
		super();
		Id = id;
		Nom = nom;
		Sexe = sexe;
	}
	public Personne(int id, String nom) {
		// TODO Auto-generated constructor stub
		Id = id;
		Nom = nom;
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
