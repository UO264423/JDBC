package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;

public class FindMechanicById {
	private static String SQL = "select id, dni, name, surname from TMechanics where id = ? ";
	MechanicDto mdto;

	public FindMechanicById(MechanicDto mdto) {
		this.mdto=mdto;
	}
	
	public MechanicDto execute(){
		MechanicDto mdtoToReturn = new MechanicDto();
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			pst.setString(1, mdto.id);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				System.out.println("-.-.-");
			}
			mdtoToReturn = DtoAssembler.toMechanicDto(rs);
			Console.printf("Dni: %d\nNombre: %d\nApellido:\n",mdto.dni,mdto.name,mdto.surname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
		return mdtoToReturn;
	}
}
