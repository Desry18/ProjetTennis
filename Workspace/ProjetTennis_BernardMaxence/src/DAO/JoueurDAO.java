package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur A INNER JOIN Personne B ON A.id=B.id WHERE id =" + id);
			if(result.first())
				joueur = new Joueur(id, result.getString("Nom"), result.getString("Sexe"));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return joueur;
	}
	
	
	
	public ArrayList<Joueur> getListHomme(){
		ArrayList<Joueur> hommeListe = new ArrayList<Joueur>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur A INNER JOIN Personne B ON A.id=B.id WHERE Sexe = 'Homme'");
					while(result.next())
						hommeListe.add(new Joueur(result.getInt("Id"), result.getString("Nom"), result.getString("Sexe")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hommeListe;
	}
	public ArrayList<Joueur> getListFemme(){
			ArrayList<Joueur> femmeListe = new ArrayList<Joueur>();
			try {
				ResultSet result = this.connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur A INNER JOIN Personne B ON A.id=B.id WHERE Sexe = 'Femme'");
						while(result.next())
							femmeListe.add(new Joueur(result.getInt("Id"), result.getString("Nom"), result.getString("Sexe")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return femmeListe;
				
		}
	
	public ArrayList<Joueur> getAll(){
		ArrayList<Joueur> joueur = new ArrayList<Joueur>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Joueur A INNER JOIN Personne B ON A.id=B.id");
					while(result.next())
						joueur.add(new Joueur(result.getInt("Id"), result.getString("Nom"), result.getString("Sexe")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return joueur;
			
	}
	}



