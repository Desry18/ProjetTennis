package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import BUSINESS.Joueur;

public class JoueurDAO extends DAO<Joueur>{

	

	public JoueurDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Joueur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Joueur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Joueur obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Joueur find(int id){
		Joueur joueur = new Joueur();
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Id = " + id);
			if(result.first())
				joueur = new Joueur(id, result.getString("Nom"), result.getString("Sexe"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return joueur;
	}


}
