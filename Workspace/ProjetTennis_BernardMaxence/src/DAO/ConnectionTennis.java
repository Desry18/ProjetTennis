package DAO;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import javax.swing.JOptionPane;

public class ConnectionTennis {

	private static java.sql.Connection instance = null;
	
	private ConnectionTennis(){
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://./DBTennis.accdb";
			instance = DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException ex){
	JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		}
		catch (SQLException ex) {
	JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex.getMessage());
		}
		if (instance == null) {
            JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
        }
	}
	
	public static Connection getInstance() {
		if(instance == null){
			new ConnectionTennis();
		}
		return (Connection) instance;
	}

}

