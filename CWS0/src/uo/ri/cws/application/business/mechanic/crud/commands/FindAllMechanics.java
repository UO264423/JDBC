package uo.ri.cws.application.business.mechanic.crud.commands;

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
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;

public class FindAllMechanics {
	

	public FindAllMechanics() {

	}
	
	public List<MechanicDto> execute(){
		MechanicGateway mg = PersistenceFactory.forMechanic();

		List<MechanicRecord> mechanicRecords = mg.findAll();
		
		return DtoAssembler.toDtoList(mechanicRecords);		
		
	}
	
}
