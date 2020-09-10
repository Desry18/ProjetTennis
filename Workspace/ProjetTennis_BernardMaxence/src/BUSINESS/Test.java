package BUSINESS;

import java.util.ArrayList;
import java.util.Collections;
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
		ArrayList<Equipe> equipes = new ArrayList<Equipe>();

		ArrayList<Joueur> joueurs = ((JoueurDAO) joueurDAO).getAll();
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
		

        //Tournoi algo = new Tournoi(true, 64, listeHomme, listeArbitre, listeCourt);
        //List<Match> matches = algo.lancerMatch();
        //System.out.print(matches.size());
        
        
        Collections.shuffle(joueurs);
		for(int i = 0 ; i < 256 ; i+=2) {
        	Equipe e = new Equipe(joueurs.get(i), joueurs.get((i+1)));
        	equipes.add(e); 
        
        
        

	}
		int i = 1;
		for (Equipe e : equipes)
		{
			
			System.out.println("Equipe " + i + " : " +e.getJoueurA().getNom() + " et  " + e.getJoueurB().getNom()) ;
			i++;
		
		}
		
		int cpt = 0;
		for(Joueur j : listeHomme) {
			Equipe e = new Equipe(j);
			cpt++;
			System.out.println("Equipe " + cpt + " : " +e.getJoueurA().getNom()) ;

		}
		
		int cpt2 = 0;
		for(Joueur j : listeFemme) {
			Equipe e = new Equipe(j);
			cpt2++;
			System.out.println("Equipe " + cpt2 + " : " +e.getJoueurA().getNom()) ;

		}

}
}
