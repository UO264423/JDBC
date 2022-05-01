package uo.ri.cws.application.business.mechanic.crud.commands;


import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;

public class AddMechanic implements Command<MechanicDto> {

	MechanicDto mdto;

	public AddMechanic(MechanicDto mdto) {
		this.mdto = mdto;
	}

	@Override
	public MechanicDto execute() {
		MechanicGateway mg = PersistenceFactory.forMechanic();
		mg.add(DtoAssembler.toRecord(mdto));
		return mdto;
	}
}
