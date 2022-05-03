package uo.ri.cws.application.persistence.mechanic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;
import uo.ri.cws.application.persistence.util.Conf;
import uo.ri.cws.application.persistence.util.RecordAssembler;

public class MechanicGatewayImpl implements MechanicGateway {

	private String SQL = "";
	// Process
	private Connection c = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private Conf conf = new Conf();

	@Override
	public void add(MechanicRecord t) {
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("MECHANIC_ADD");
			pst = c.prepareStatement(SQL);
			pst.setString(1, t.id);
			pst.setString(2, t.dni);
			pst.setString(3, t.name);
			pst.setString(4, t.surname);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 finally {
		Jdbc.close(rs, pst);
	}

	}

	@Override
	public void remove(String id) {
		try {
		c = Jdbc.getConnection();
		SQL = conf.getProperty("MECHANIC_REMOVE");
		pst = c.prepareStatement(SQL);
		pst.setString(1, id);
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		Jdbc.close(rs, pst);
	}
}

	@Override
	public void update(MechanicRecord t) {
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("MECHANIC_UPDATE");
			pst = c.prepareStatement(SQL);
			pst.setString(1, t.name);
			pst.setString(2, t.surname);
			pst.setString(3, t.id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}

	}

	@Override
	public Optional<MechanicRecord> findById(String id) {
		Optional<MechanicRecord> mechanic = Optional.ofNullable(new MechanicRecord());
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("MECHANIC_FIND_BY_ID");
			pst = c.prepareStatement(SQL);
			pst.setString(1, id);
			rs = pst.executeQuery();
			
			mechanic = RecordAssembler.toMechanicRecord(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return mechanic;
		
	}
	

	@Override
	public List<MechanicRecord> findAll() {
		List<MechanicRecord> mechanics = new ArrayList<MechanicRecord>();
		try {
			c = Jdbc.getConnection();
			SQL = conf.getProperty("MECHANIC_FIND_ALL");
			pst = c.prepareStatement(SQL);
			
			rs = pst.executeQuery();
			
			mechanics = RecordAssembler.toMechanicRecordList(rs);
			return mechanics;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Jdbc.close(rs, pst);
		}
		return mechanics;
		
	}

	@Override
	public Optional<MechanicRecord> findByDni(String dni) {
		Optional<MechanicRecord> mechanic = Optional.ofNullable(new MechanicRecord());
		try{
			c = Jdbc.getConnection();
			SQL = conf.getProperty("MECHANIC_FIND_BY_DNI");
			pst = c.prepareStatement(SQL);
			pst.setString(1, dni);
			rs = pst.executeQuery();
			mechanic = RecordAssembler.toMechanicRecord(rs);
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			Jdbc.close(rs, pst);
		}
		return mechanic;	
	}
}















