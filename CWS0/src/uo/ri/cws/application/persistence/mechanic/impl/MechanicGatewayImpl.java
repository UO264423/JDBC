package uo.ri.cws.application.persistence.mechanic.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;
import uo.ri.cws.application.persistence.util.Conf;

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
			pst.setString(1, UUID.randomUUID().toString());
			pst.setString(2, t.dni);
			pst.setString(3, t.name);
			pst.setString(4, t.surname);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(MechanicRecord t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<MechanicRecord> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MechanicRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MechanicRecord> findByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

}
