package uo.ri.cws.application.business.mechanic.crud.commands;


import java.util.Optional;

import alb.util.console.Console;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;

public class FindMechanicByDni implements Command<Optional<MechanicDto>>{
	String dniMechanic;

	public FindMechanicByDni(String dniMechanic) {
		this.dniMechanic=dniMechanic;
	}
	
	@Override
	public Optional<MechanicDto> execute(){
		MechanicGateway mg = PersistenceFactory.forMechanic();

		Optional<MechanicRecord> mechanicRecord = mg.findByDni(this.dniMechanic);
		Optional<MechanicDto> mdtoToReturn = DtoAssembler.toDto(mechanicRecord);
		
		Console.printf("Dni: %s\nNombre: %s\nApellido: %s\n",mdtoToReturn.get().dni,mdtoToReturn.get().name,mdtoToReturn.get().surname);

		return mdtoToReturn;		
		
	}


}
