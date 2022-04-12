package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;

public class AddMechanic {
	
	MechanicDto mdto;
	private static String SQL = "insert into TMechanics(id, dni, name, surname) values (?, ?, ?, ?)";
	
	public AddMechanic(MechanicDto mdto) {
		this.mdto=mdto;
	}
	
	public MechanicDto execute() {
		// Process
				Connection c = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				try {
					c = Jdbc.getConnection();
					
					pst = c.prepareStatement(SQL);
					pst.setString(1, UUID.randomUUID().toString());
					pst.setString(2, mdto.dni);
					pst.setString(3, mdto.name);
					pst.setString(4, mdto.surname);
					
					pst.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				finally {
					Jdbc.close(rs, pst, c);
				}
		return mdto;
		
	}
}
