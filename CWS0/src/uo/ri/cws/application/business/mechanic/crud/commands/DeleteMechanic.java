package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;

public class DeleteMechanic {
	
	private static String SQL = "delete from TMechanics where id = ?";
	
	MechanicDto mdto;

	public DeleteMechanic(MechanicDto mdto) {
		this.mdto=mdto;
	}
	
	public void execute() {
		
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			pst.setString(1, mdto.id);
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
		
	}
}
