package uo.ri.cws.application.business.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;

public class FindMechanicByDni{
	private static String SQL = "select id, dni, name, surname from TMechanics where dni = ? ";
	String dniMechanic;

	public FindMechanicByDni(String dniMechanic) {
		this.dniMechanic=dniMechanic;
	}
	
	public Optional<MechanicDto> execute(){
		MechanicDto mdtoToReturn = new MechanicDto();
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			pst.setString(1, dniMechanic);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				mdtoToReturn = DtoAssembler.toMechanicDto(rs);
			}
			
			Console.printf("Dni: %s\nNombre: %s\nApellido: %s\n",mdtoToReturn.dni,mdtoToReturn.name,mdtoToReturn.surname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
		return Optional.ofNullable(mdtoToReturn);
	}
}
