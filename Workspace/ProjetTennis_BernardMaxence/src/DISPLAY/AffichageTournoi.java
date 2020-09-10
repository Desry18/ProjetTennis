package DISPLAY;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;



public class AffichageTournoi {
	
	 AffichageTournoi(){    
	        JFrame fenetre1=new JFrame("Accueil"); 
	                    //submit button
	        JButton b=new JButton("Submit");    
	        b.setBounds(100,100,140, 40);    
	                    //enter name label
	        JLabel label = new JLabel();        
	        label.setText("Enter Name :");
	        label.setBounds(10, 10, 100, 100);
	                    //empty label which will show event after button clicked
	        JLabel label1 = new JLabel();
	        label1.setBounds(10, 110, 200, 100);
	                    //textfield to enter name
	                    //add to frame
	        fenetre1.add(label1);
	        fenetre1.add(label);
	        fenetre1.add(b);    
	        fenetre1.setSize(300,300);    
	        fenetre1.setLayout(null);    
	        fenetre1.setVisible(true);    
	        fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	        
	                            //action listener
	        b.addActionListener(new ActionListener() {
	            
	            @Override
	            public void actionPerformed(ActionEvent arg0) {
	                    label1.setText("Name has been submitted : ");                
	            }          
	          });
	        }         
	    
	    
	        public static void main(String[] args) {    
	            new AffichageTournoi();    
	        }    
}
