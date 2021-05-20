package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.model.Informazione;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public Informazione getInfo(River r) {
		
		String sql="SELECT MAX(f.day) as ultimo, MIN(f.day) as primo, AVG(f.flow) as media, COUNT(*) as tot "
				+ "FROM flow f "
				+ "WHERE f.river = ? ";
		
		Informazione i=new Informazione(null, null, 0,0);
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			ResultSet res = st.executeQuery();
			
			
			if(res.next()) {
				
				i.setPrima(res.getDate("primo").toLocalDate());
				i.setUltima(res.getDate("ultimo").toLocalDate());
				i.setTotale(res.getInt("tot"));
				i.setMedia(res.getDouble("media"));
				
			}
			
			
			
		}
		catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
		
		return i;

		
		
	}
}
