package BUSINESS;

import java.util.ArrayList;
import java.util.List;

import DAO.ArbitreDAO;
import DAO.ConnectionTennis;
import DAO.CourtDAO;
import DAO.DAO;
import DAO.JoueurDAO;
//import DAO.TestDAO;




public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String coucou = "coucouuu";
		//TestDAO bjr = new TestDAO();
		DAO<Joueur> joueurDAO = new JoueurDAO(ConnectionTennis.getInstance());
		DAO<Arbitre> arbitreDAO = new ArbitreDAO(ConnectionTennis.getInstance());
		DAO<Court> courtDAO = new CourtDAO(ConnectionTennis.getInstance());



		ArrayList<Joueur> listeHomme = ((JoueurDAO) joueurDAO).getListHomme();
		
		//for(int i = 0; i < listeHomme.size(); i++)
			//System.out.println(listeHomme.get(i).getId() + " " + listeHomme.get(i).getNom() );
		ArrayList<Joueur> listeFemme = ((JoueurDAO) joueurDAO).getListFemme();
		//for(int i = 0; i < listeFemme.size(); i++)
			//System.out.println(listeFemme.get(i).getId() + " " + listeFemme.get(i).getNom() );
		
		ArrayList<Arbitre> listeArbitre = ((ArbitreDAO) arbitreDAO).getListArbitre();
		//for(int i = 0; i < listeArbitre.size(); i++)
			//System.out.println(listeArbitre.get(i).getId() + " " + listeArbitre.get(i).getNom() );
		
		ArrayList<Court> listeCourt = ((CourtDAO) courtDAO).getListCourt();
		//for(int i = 0; i < listeCourt.size(); i++)
			//System.out.println(listeCourt.get(i).getIdC() + " " + listeCourt.get(i).getNomC() );
		

        Tournoi algo = new Tournoi(true, 64, listeHomme, listeArbitre, listeCourt);
        List<Match> matches = algo.lancerMatch();
        System.out.print(matches.size());

	}

}
