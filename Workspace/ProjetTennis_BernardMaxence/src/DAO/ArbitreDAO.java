package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BUSINESS.Arbitre;
import BUSINESS.Joueur;

public class ArbitreDAO extends DAO<Arbitre>{

	public ArbitreDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Arbitre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Arbitre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Arbitre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Arbitre find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Arbitre> getListArbitre(){
		ArrayList<Arbitre> arbitreListe = new ArrayList<Arbitre>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Arbitre A INNER JOIN Personne B ON A.id=B.id");
					while(result.next())
						arbitreListe.add(new Arbitre(result.getInt("Id"), result.getString("Nom"), result.getString("Sexe")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arbitreListe;
			
	}

}
