package uo.ri.cws.application.business.mechanic.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import alb.util.console.Console;
import alb.util.jdbc.Jdbc;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;

public class FindAllMechanic {
	
	private static String SQL = "select id, dni, name, surname from TMechanics";
	MechanicDto mdto;
	

	public FindAllMechanic(MechanicDto mdto) {
		this.mdto=mdto;
	}
	
	public List<MechanicDto> exexute(){
		List<MechanicDto> lmdto = new ArrayList<MechanicDto>();
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();
			
			pst = c.prepareStatement(SQL);
			
			rs = pst.executeQuery();
			lmdto = DtoAssembler.toMechanicDtoList(rs);				
			for(MechanicDto mdto : lmdto) {
				Console.printf("%s\t%s\t%s\t%s\n",mdto.id,mdto.dni,mdto.name,mdto.surname);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			Jdbc.close(rs, pst, c);
		}
		return lmdto;
	}
	
}
