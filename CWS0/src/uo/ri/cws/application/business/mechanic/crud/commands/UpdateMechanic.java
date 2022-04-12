package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;

public class UpdateMechanic {
	
	MechanicDto mdto;
	
	private static String SQL = 
			"update TMechanics " +
				"set name = ?, surname = ? " +
				"where id = ?";


	public UpdateMechanic(MechanicDto mdto) {
		this.mdto=mdto;
	}
	
	
	public void execute() {
		// Process
				Connection c = null;
				PreparedStatement pst = null;
				ResultSet rs = null;

				try {
					c = Jdbc.getConnection();
					
					pst = c.prepareStatement(SQL);
					pst.setString(1, mdto.name);
					pst.setString(2, mdto.surname);
					pst.setString(3, mdto.id);
					
					pst.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				finally {
					Jdbc.close(rs, pst, c);
				}
	}
}
