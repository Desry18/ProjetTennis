package BUSINESS;

import java.util.List;

public class Match {
    private List<Joueur> Joueurs;
    private Joueur Gagnant;
    private List<SetTennis> Sets; 
    private Arbitre Arbitre;
    private Court Court;
    private int num;
   
    
    public Match(List<Joueur> joueurs, List<SetTennis> sets, Arbitre arbitre, Court court, int nm, Joueur gagnant) {
        Joueurs = joueurs;
        Sets = sets;
        Arbitre = arbitre;
        Court = court;
        num = nm;
        Gagnant = gagnant;
    }


	public List<Joueur> getJoueurs() {
		return Joueurs;
	}


	public void setJoueurs(List<Joueur> joueurs) {
		Joueurs = joueurs;
	}


	public Joueur getGagnant() {
		return Gagnant;
	}


	public void setGagnant(Joueur gagnant) {
		Gagnant = gagnant;
	}


	public List<SetTennis> getSets() {
		return Sets;
	}


	public void setSets(List<SetTennis> sets) {
		Sets = sets;
	}


	public Arbitre getArbitre() {
		return Arbitre;
	}


	public void setArbitre(Arbitre arbitre) {
		Arbitre = arbitre;
	}


	public Court getCourt() {
		return Court;
	}


	public void setCourt(Court court) {
		Court = court;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
    
    
}

