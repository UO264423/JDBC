package uo.ri.cws.application.business.mechanic.crud.commands;


import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.util.DtoAssembler;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;

public class UpdateMechanic implements Command<Void> {
	
	MechanicDto mdto;
	
	public UpdateMechanic(MechanicDto mdto)  {
		this.mdto=mdto;
	}

	@Override
	public Void execute() {
		MechanicGateway mg = PersistenceFactory.forMechanic();
		mg.update(DtoAssembler.toRecord(mdto));
		return null;
	}
	
}
