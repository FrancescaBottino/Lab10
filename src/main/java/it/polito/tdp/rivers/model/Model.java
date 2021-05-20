package it.polito.tdp.rivers.model;

import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private RiversDAO dao;

	public Model() {
		
		dao= new RiversDAO();
	}
	
	public List<River> getAllRivers(){
		
		return dao.getAllRivers();
	}
	
	public Informazione getInfo(River r) {
		return dao.getInfo(r);
	}
	
	
	

}
