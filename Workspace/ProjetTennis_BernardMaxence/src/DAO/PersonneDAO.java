package DAO;

import java.sql.Connection;

import BUSINESS.Personne;

public class PersonneDAO extends DAO<Personne> {

	public PersonneDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Personne obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personne find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
