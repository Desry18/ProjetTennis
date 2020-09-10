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
			ArrayList<Joueur> listeHomme = ((JoueurDAO) joueurDAO).getListHomme();
			ArrayList<Joueur> listeFemme = ((JoueurDAO) joueurDAO).getListFemme();
			ArrayList<Arbitre> listeArbitre = ((ArbitreDAO) arbitreDAO).getListArbitre();
			ArrayList<Court> listeCourt = ((CourtDAO) courtDAO).getListCourt();

	    	
	    	QuickStart frame = new QuickStart();
	    	frame.setSize(1200, 600);
	    	
	    	JButton homme=new JButton("Hommes Simples");    
	        homme.setBounds(10,150,214, 54);
	        contentPane.add(homme);
	        
	        JButton femme=new JButton("Femmes Simples");    
	        femme.setBounds(200,150,214, 54);
	        contentPane.add(femme);
	        
	        JButton db =new JButton("Doubles");    
	        db.setBounds(10,150,214, 54);	        
	        contentPane.add(db);
	        
	        JButton next =new JButton("Prochain round");    
	        next.setBounds(10,820,300, 54);	
	        
	        JButton nextf =new JButton("Prochain round");    
	        nextf.setBounds(10,820,300, 54);	
	        	            
	         
	   
	        frame.setVisible(true);

	        homme.addActionListener(new ActionListener() {	            
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                   contentPane.removeAll();
	                   contentPane.add(next);
	       	           List<Joueur> gagnants = new ArrayList<Joueur>();

	                   frame.setSize(1200,600);
	                   Tournoi t = new Tournoi(true, 64, listeHomme, listeArbitre, listeCourt);
	                   List<Match> matches = t.lancerMatch();
	                   int i =0;

	                   for (Match match : matches) {
	                       JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getNom());
	                       lblj1.setBounds(10, 11 + (12*i), 414, 54);
	                       contentPane.add(lblj1);

	                       JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getNom());
	                       lblj2.setBounds(90, 11 + (12*i), 414, 54);
	                       contentPane.add(lblj2); 

	                       JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getNom());
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
	                          frame.setSize(1200,600);
	                          int nbg = gagnants.size();
	                          Tournoi t2 = new Tournoi(true, 32, gagnants , listeArbitre, listeCourt);
	                          List<Match> matches2 = t2.lancerMatch();

	                          int i =0;
	                          gagnants.clear();
	                          for (Match match : matches2) {
	                              JLabel lblj1 = new JLabel((i+1) + match.getJoueurs().get(0).getNom());
	                              lblj1.setBounds(10, 11 + (12*i), 414, 54);
	                              contentPane.add(lblj1);

	                              JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getNom());
	                              lblj2.setBounds(90, 11 + (12*i), 414, 54);
	                              contentPane.add(lblj2); 

	                              JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getNom());
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
                   frame.setSize(1200,600);
                   Tournoi t2 = new Tournoi(false, 64, listeFemme, listeArbitre, listeCourt);
                   List<Match> matches2 = t2.lancerMatch();
                   System.out.print(matches2.size());
                   int i =0;

                   for (Match match : matches2) {
                	   //gagnants.add(match.getGagnant());
                       JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getNom());
                       lblj1.setBounds(10, 11 + (12*i), 414, 54);
                       contentPane.add(lblj1);

                       JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getNom());
                       lblj2.setBounds(90, 11 + (12*i), 414, 54);
                       contentPane.add(lblj2); 

                       JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getNom());
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
	       
          
            
            nextf.addActionListener(new ActionListener() {	            
                @Override
                public void actionPerformed(ActionEvent arg0) {
                contentPane.removeAll();
                frame.setSize(1200,600);
                Tournoi t2 = new Tournoi(false, 64, listeHomme , listeArbitre, listeCourt);
                List<Match> matches2 = t2.lancerMatch();
                System.out.print(matches2.size());
                int i =0;

                for (Match match : matches2) {
                    JLabel lblj1 = new JLabel(match.getJoueurs().get(0).getNom());
                    lblj1.setBounds(10, 11 + (12*i), 414, 54);
                    contentPane.add(lblj1);

                    JLabel lblj2 = new JLabel(" vs    " + match.getJoueurs().get(1).getNom());
                    lblj2.setBounds(90, 11 + (12*i), 414, 54);
                    contentPane.add(lblj2); 

                    JLabel lblGagnant = new JLabel(" Gagnant : " + match.getGagnant().getNom());
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
           

 }}

