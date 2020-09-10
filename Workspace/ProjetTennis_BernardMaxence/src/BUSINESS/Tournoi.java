package BUSINESS;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Tournoi {
	boolean hommeS;
	int setmax;
	int ord;
    int setgg;
    LocalDateTime dateDepart = LocalDateTime.of(2019, 05, 26, 10, 0);
	List <Arbitre> arbitre = new ArrayList<Arbitre>();
    List <Court> court = new ArrayList<Court>();
    List<Joueur> joueurs = new ArrayList<Joueur>();
    

	public Tournoi( boolean h, int or, List<Joueur> JoueursList, List<Arbitre> listeArbitre, List<Court> listeCourt)
	{
		hommeS = h;
        ord = or;
        this.joueurs = JoueursList;	
        this.arbitre = listeArbitre;
        this.court = listeCourt;

	}
	public List<Match> lancerMatch()
	{		
		final List <Court> courtu = new ArrayList<Court>();
		final List <Arbitre> arbitreu = new ArrayList<Arbitre>();
		Collections.shuffle(arbitre);
        Collections.shuffle(court);
        Collections.shuffle(joueurs);

        List<Match> matches = new ArrayList<Match>();
		int cptarbitre = 0; 
		int cptcourt = 0;
		if(hommeS)
		{
			setmax = 5;
			setgg = 3;
		}
		else
		{
			setmax = 3;
			setgg = 2;
        }
        int j = 0;
		for (int i = 0; i < ord; i++)
		{			
			int setj1 = 0;
			int setj2 = 0;
			int numset = 0;
			int jeuj1 = 0;
			int jeuj2 = 0;
            final Random rand = new Random();
            List<SetTennis> setTennis = new ArrayList<SetTennis>();
			while (setj1 != setgg && setj2 != setgg)
			{
				numset ++;
				final int toss = rand.nextInt(2); 
				if (toss == 1)
					{
					setj1++ ;
					jeuj1 = 6;
					jeuj2 = rand.nextInt(7);
					if (jeuj2 == 6 || jeuj2 == 5)
						if(numset == setmax && jeuj2 == 6)
						{
							while ((jeuj1 - jeuj2) < 2 && (jeuj2 - jeuj1) < 2 )
							{
								final int alea = rand.nextInt(2);
								if(alea == 0)
									jeuj1++;
								else 
									jeuj2++;
							}
						}
						else
							jeuj1 = 7;
					}
				else
				{			
						setj2++ ;
						jeuj2 = 6;
						jeuj1 = rand.nextInt(7);
						if (jeuj1 == 6 || jeuj1 == 5)
						{
							if(numset == setmax && jeuj1 == 6)
							{
								while ((jeuj1 - jeuj2) < 2 && (jeuj2 - jeuj1) < 2 )
								{
									final int alea = rand.nextInt(2);
									if(alea == 0)
										jeuj1++;
									else 
										jeuj2++;
								}
							}
							else
								jeuj2 = 7;					
						}
                }
                setTennis.add(new SetTennis(jeuj1,jeuj2));
			}
			arbitreu.add(arbitre.get(cptarbitre));
            courtu.add(court.get(cptcourt));
            
            List<Joueur> joueursMatch = new ArrayList<Joueur>();
            joueursMatch.add(joueurs.get(j));
            joueursMatch.add(joueurs.get(j+1));
			if(setj1 == setgg){
                matches.add(new Match(joueursMatch, setTennis, arbitreu.get(cptarbitre), courtu.get(cptcourt), (i+1), joueurs.get(j)));
            }
				
			else {
                matches.add(new Match(joueursMatch, setTennis, arbitreu.get(cptarbitre), courtu.get(cptcourt), (i+1), joueurs.get(j+1)));
            }
            cptarbitre++;
            cptcourt++;
            j+=2;
			if (cptarbitre == arbitre.size())		
			{
				Collections.shuffle(arbitre);
				cptarbitre = 0; 
				arbitreu.clear();
			}
			if (cptcourt == court.size())			
			{
                dateDepart = dateDepart.plusDays(1);
				Collections.shuffle(court);
				cptcourt = 0; 
				courtu.clear();
			}
        }
        return matches;
	}
}
