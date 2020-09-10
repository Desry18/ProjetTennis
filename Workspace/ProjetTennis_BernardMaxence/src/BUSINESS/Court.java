package BUSINESS;

import java.io.Serializable;

public class Court implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5616704525968314728L;
	private int IdC;
	private String NomC;
	
	
	public Court() {
		
	}
	
	
	
	
	public Court(int idC, String nomC) {
		super();
		IdC = idC;
		NomC = nomC;
	}




	public int getIdC() {
		return IdC;
	}
	public void setIdC(int idC) {
		IdC = idC;
	}
	public String getNomC() {
		return NomC;
	}
	public void setNomC(String nomC) {
		NomC = nomC;
	}
	
}
