package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import BUSINESS.Court;

public class CourtDAO extends DAO<Court>{

	public CourtDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Court obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Court find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Court> getListCourt(){
		ArrayList<Court> courtListe = new ArrayList<Court>();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Court");
					while(result.next())
						courtListe.add(new Court(result.getInt("IdC"), result.getString("NomC")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courtListe;
	}
}
