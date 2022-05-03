package uo.ri.cws.application.business.mechanic.crud.commands;


import java.util.Optional;

import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;
import uo.ri.cws.application.persistence.mechanic.MechanicRecord;

public class FindMechanicById implements Command<Optional<MechanicDto>>{
	String idMechanic;

	public FindMechanicById(String idMechanic) {
		this.idMechanic=idMechanic;
	}
	
	@Override
	public Optional<MechanicDto> execute(){
		MechanicGateway mg = PersistenceFactory.forMechanic();
		Optional<MechanicRecord> mr = mg.findById(idMechanic);
		Optional<MechanicDto> mdto = DtoAssembler.toDto(mr);
		return mdto;
	}


}
