package BUSINESS;

import DAO.ConnectionTennis;
import DAO.DAO;
import DAO.JoueurDAO;
//import DAO.TestDAO;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String coucou = "coucouuu";
		//TestDAO bjr = new TestDAO();
		DAO<Joueur> joueurDAO = new JoueurDAO(ConnectionTennis.getInstance());
		Joueur joueur = joueurDAO.find(1);
		System.out.println(joueur.getNom());

	}

}
