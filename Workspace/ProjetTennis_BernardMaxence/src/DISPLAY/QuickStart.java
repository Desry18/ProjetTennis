package DISPLAY;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUSINESS.Arbitre;
import BUSINESS.Court;
import BUSINESS.Equipe;
import BUSINESS.Joueur;
import BUSINESS.Match;
import BUSINESS.SetTennis;
import BUSINESS.Tournoi;
import DAO.ArbitreDAO;
import DAO.ConnectionTennis;
import DAO.CourtDAO;
import DAO.DAO;
import DAO.JoueurDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
class QuickStart extends JFrame {
	    private static final long serialVersionUID = -6989463283523240348L;
		private static JPanel contentPane;

	 
	    public QuickStart() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
	 
	    }
	    public static void main(String[] args) {
	    	DAO<Joueur> joueurDAO = new JoueurDAO(ConnectionTennis.getInstance());
			DAO<Arbitre> arbitreDAO = new ArbitreDAO(ConnectionTennis.getInstance());
			DAO<Court> courtDAO = new CourtDAO(ConnectionTennis.getInstance());
			ArrayList<Joueur> joueurs = ((JoueurDAO) joueurDAO).getAll();

			ArrayList<Equipe> listeHomme = new ArrayList<Equipe>();
			ArrayList<Equipe> listeFemme = new ArrayList<Equipe>();
			ArrayList<Equipe> listeDouble = new ArrayList<Equipe>();
			ArrayList<Joueur> listeFemmes = ((JoueurDAO) joueurDAO).getListFemme();
			ArrayList<Arbitre> listeArbitre = ((ArbitreDAO) arbitreDAO).getListArbitre();
			ArrayList<Court> listeCourt = ((CourtDAO) courtDAO).getListCourt();
	        List<Equipe> gagnants = new ArrayList<Equipe>();
			ArrayList<Joueur> listeHommes = ((JoueurDAO) joueurDAO).getListHomme();
			
			for(Joueur j : listeHommes) {
				Equipe e = new Equipe(j);
				listeHomme.add(e);
			}
			
			for(Joueur j : listeFemmes) {
				Equipe e = new Equipe(j);
				listeFemme.add(e);
			}
			
	        Collections.shuffle(joueurs);
			for(int i = 0 ; i < 256 ; i+=2) {
	        	Equipe e = new Equipe(joueurs.get(i), joueurs.get((i+1)));
	        	listeDouble.add(e); 
			}
			
			
			


	    	
	    	QuickStart frame = new QuickStart();
	    	frame.setSize(1200, 600);
	    	
	    	JButton homme=new JButton("Hommes Simples");    
	        homme.setBounds(10,150,214, 54);
	        contentPane.add(homme);
	        
	        JButton femme=new JButton("Femmes Simples");    
	        femme.setBounds(200,150,214, 54);
	        contentPane.add(femme);
	        
	        JButton db =new JButton("Doubles");    
	        db.setBounds(390,150,214, 54);	        
	        contentPane.add(db);
	        
	        JButton next =new JButton("Prochain round");    
	        next.setBounds(10,820,300, 54);	
	        
	        JButton nextf =new JButton("Prochain round");    
	        nextf.setBounds(10,820,300, 54);
	        
	        JButton acc =new JButton("Accueil");    
	        acc.setBounds(600,820,300, 54);
	        	            
	         
	   
	        frame.setVisible(true);

	        homme.addActionListener(new ActionListener() {	            
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                   contentPane.removeAll();
	                   contentPane.add(next);
	                   contentPane.add(acc);

	                   frame.setSize(1200,600);
	                   Tournoi t = new Tournoi(true, 64, listeHomme, listeArbitre, listeCourt);
	                   List<Match> matches = t.lancerMatch();
	                   int i =0;

	                   for (Match match : matches) {
	                       JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom());
	                       lblj1.setBounds(10, 11 + (12*i), 414, 54);
	                       contentPane.add(lblj1);

	                       JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom());
	                       lblj2.setBounds(90, 11 + (12*i), 414, 54);
	                       contentPane.add(lblj2); 

	                       JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom());
	                       lblGagnant.setBounds(470, 11 + (12*i), 414, 54);
	                       contentPane.add(lblGagnant);
	                       

	                       JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
	                       lblArbitre.setBounds(620, 11 + (12*i), 414, 54);
	                       contentPane.add(lblArbitre);

	                       JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC());
	                       lblCourt.setBounds(820, 11 + (12*i), 414, 54);
	                       contentPane.add(lblCourt);

	                       
	                       int j = 0;
	                       for (SetTennis set : match.getSets() ) {

	                           JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
	                           lblSet.setBounds((200 + j), 11 + (12*i), 414, 54);
	                           contentPane.add(lblSet);
	                           j+=30;
	                       }
	                      i++;
	                      gagnants.add(match.getGagnant());

	                      
	                      
                      next.addActionListener(new ActionListener() {	            
                          @Override
                          public void actionPerformed(ActionEvent arg0) {
                          contentPane.removeAll();
   	                      contentPane.add(next);
   	                      contentPane.add(acc);

                          frame.setSize(1200,600);
                          int nbg = gagnants.size()/2;
                          //round = round/2;
                          Tournoi t2 = new Tournoi(true, nbg , gagnants , listeArbitre, listeCourt);
                          List<Match> matches2 = t2.lancerMatch();

                          int i =0;
                          List <Equipe> gagnants = new ArrayList <Equipe>();
                          for (Match match : matches2) {
                              JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom());
                              lblj1.setBounds(10, 11 + (12*i), 414, 54);
                              contentPane.add(lblj1);

                              JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom());
                              lblj2.setBounds(90, 11 + (12*i), 414, 54);
                              contentPane.add(lblj2); 

                              JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom());
                              lblGagnant.setBounds(470, 11 + (12*i), 414, 54);
                              contentPane.add(lblGagnant);

                              JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
                              lblArbitre.setBounds(620, 11 + (12*i), 414, 54);
                              contentPane.add(lblArbitre);

                              JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC() + nbg);
                              lblCourt.setBounds(820, 11 + (12*i), 414, 54);
                              contentPane.add(lblCourt);


                              int j = 0;
                              for (SetTennis set : match.getSets() ) {

                                  JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
                                  lblSet.setBounds((200 + j), 11 + (12*i), 414, 54);
                                  contentPane.add(lblSet);
                                  j+=30;
                              }
                             i++;
                             gagnants.add(match.getGagnant());
                      }
                          //gagnants = gagnants2;
                  }
                             
                 });
                      
                     
               }
           }
                      
          });
        
        
		        femme.addActionListener(new ActionListener() {	            
		        @Override
		        public void actionPerformed(ActionEvent arg0) {
		               contentPane.removeAll();
		               contentPane.add(nextf);
	                   contentPane.add(acc);

		               frame.setSize(1200,600);
		               Tournoi t2 = new Tournoi(false, 64, listeFemme, listeArbitre, listeCourt);
		               List<Match> matches2 = t2.lancerMatch();
		               int i =0;
		
		               for (Match match : matches2) {
		            	   //gagnants.add(match.getGagnant());
		                   JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom());
		                   lblj1.setBounds(10, 11 + (12*i), 414, 54);
		                   contentPane.add(lblj1);
		
		                   JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom());
		                   lblj2.setBounds(90, 11 + (12*i), 414, 54);
		                   contentPane.add(lblj2); 
		
		                   JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom());
		                   lblGagnant.setBounds(470, 11 + (12*i), 414, 54);
		                   contentPane.add(lblGagnant);
		
		                   JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
		                   lblArbitre.setBounds(620, 11 + (12*i), 414, 54);
		                   contentPane.add(lblArbitre);
		
		                   JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC());
		                   lblCourt.setBounds(820, 11 + (12*i), 414, 54);
		                   contentPane.add(lblCourt);
		
		
		                   int j = 0;
		                   for (SetTennis set : match.getSets() ) {
		
		                       JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
		                       lblSet.setBounds((200 + j), 11 + (12*i), 414, 54);
		                       contentPane.add(lblSet);
		                       j+=30;
		                   }
		                  i++;
	                      gagnants.add(match.getGagnant());

	                      
		                  nextf.addActionListener(new ActionListener() {	            
					            @Override
					            public void actionPerformed(ActionEvent arg0) {
					            contentPane.removeAll();
				                contentPane.add(nextf);
				                contentPane.add(acc);

					            frame.setSize(1200,600);
					            Tournoi t2 = new Tournoi(false, 32, gagnants , listeArbitre, listeCourt);
					            List<Match> matches2 = t2.lancerMatch();
					            System.out.print(matches2.size());
					            int i =0;
					
					            for (Match match : matches2) {
					                JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom());
					                lblj1.setBounds(10, 11 + (12*i), 414, 54);
					                contentPane.add(lblj1);
					
					                JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom());
					                lblj2.setBounds(90, 11 + (12*i), 414, 54);
					                contentPane.add(lblj2); 
					
					                JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom());
					                lblGagnant.setBounds(470, 11 + (12*i), 414, 54);
					                contentPane.add(lblGagnant);
					
					                JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
					                lblArbitre.setBounds(620, 11 + (12*i), 414, 54);
					                contentPane.add(lblArbitre);
					
					                JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC());
					                lblCourt.setBounds(820, 11 + (12*i), 414, 54);
					                contentPane.add(lblCourt);
					
					
					                int j = 0;
					                for (SetTennis set : match.getSets() ) {
					
					                    JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
					                        lblSet.setBounds((200 + j), 11 + (12*i), 414, 54);
					                        contentPane.add(lblSet);
					                        j+=30;
					                    }
					                   i++;
					            }
					        }
					                   
					       });
		                  
		           }
		       }
		                  
		      });
		       
		      
			        
			        
			        
			        db.addActionListener(new ActionListener() {	            
				        @Override
				        public void actionPerformed(ActionEvent arg0) {
				               contentPane.removeAll();
				               contentPane.add(nextf);
			                   contentPane.add(acc);

				               frame.setSize(1200,600);
				               Tournoi t2 = new Tournoi(false, 64, listeDouble, listeArbitre, listeCourt);
				               List<Match> matches2 = t2.lancerMatch();
				               int i =0;
				
				               for (Match match : matches2) {
				            	   //gagnants.add(match.getGagnant());
				                   JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom() + " et " + match.getJoueurs().get(0).getJoueurB().getNom());
				                   lblj1.setBounds(10, 11 + (12*i), 414, 54);
				                   contentPane.add(lblj1);
				
				                   JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom() + " et " + match.getJoueurs().get(1).getJoueurB().getNom());
				                   lblj2.setBounds(200, 11 + (12*i), 414, 54);
				                   contentPane.add(lblj2); 
				
				                   JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom() + " et " + match.getGagnant().getJoueurB().getNom());
				                   lblGagnant.setBounds(670, 11 + (12*i), 414, 54);
				                   contentPane.add(lblGagnant);
				
				                   JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
				                   lblArbitre.setBounds(970, 11 + (12*i), 414, 54);
				                   contentPane.add(lblArbitre);
				
				                   JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC());
				                   lblCourt.setBounds(1300, 11 + (12*i), 414, 54);
				                   contentPane.add(lblCourt);
				
				
				                   int j = 0;
				                   for (SetTennis set : match.getSets() ) {
				
				                       JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
				                       lblSet.setBounds((400 + j), 11 + (12*i), 414, 54);
				                       contentPane.add(lblSet);
				                       j+=30;
				                   }
				                  i++;
			                      gagnants.add(match.getGagnant());

				                  nextf.addActionListener(new ActionListener() {	            
							            @Override
							            public void actionPerformed(ActionEvent arg0) {
							            contentPane.removeAll();
							            contentPane.add(nextf);
						                contentPane.add(acc);

							            frame.setSize(1200,600);
							            Tournoi t2 = new Tournoi(false, 32, gagnants , listeArbitre, listeCourt);
							            List<Match> matches2 = t2.lancerMatch();
							            int i =0;
							
							            for (Match match : matches2) {
							            	JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getJoueurA().getNom() + " et " + match.getJoueurs().get(0).getJoueurB().getNom());
							                   lblj1.setBounds(10, 11 + (12*i), 414, 54);
							                   contentPane.add(lblj1);
							
							                   JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getJoueurA().getNom() + " et " + match.getJoueurs().get(1).getJoueurB().getNom());
							                   lblj2.setBounds(200, 11 + (12*i), 414, 54);
							                   contentPane.add(lblj2); 
							
							                   JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getJoueurA().getNom() + " et " + match.getGagnant().getJoueurB().getNom());
							                   lblGagnant.setBounds(670, 11 + (12*i), 414, 54);
							                   contentPane.add(lblGagnant);
							
							                   JLabel lblArbitre = new JLabel(" Arbitré par  : " + match.getArbitre().getNom());
							                   lblArbitre.setBounds(970, 11 + (12*i), 414, 54);
							                   contentPane.add(lblArbitre);
							
							                   JLabel lblCourt = new JLabel(" Sur le court : " + match.getCourt().getNomC());
							                   lblCourt.setBounds(1300, 11 + (12*i), 414, 54);
							                   contentPane.add(lblCourt);
							
							
							                   int j = 0;
							                   for (SetTennis set : match.getSets() ) {
							
							                       JLabel lblSet = new JLabel(set.scoreA + " - " + set.scoreB + " | ");
							                       lblSet.setBounds((400 + j), 11 + (12*i), 414, 54);
							                       contentPane.add(lblSet);
							                       j+=30;
							                   }
							                  i++;
							            }
							        }
							                   
							       });
				           }
				       }
				                  
				      });
				       
				      
				        
			        acc.addActionListener(new ActionListener() {	            
			            @Override
			            public void actionPerformed(ActionEvent arg0) {
				            contentPane.removeAll();
			                contentPane.add(homme);

			                contentPane.add(femme);

			                contentPane.add(db);

			            }
			            });
			            
	    
			           
			
			 }}

