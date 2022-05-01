package uo.ri.cws.application.business.mechanic.crud.commands;

import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.util.command.Command;
import uo.ri.cws.application.persistence.PersistenceFactory;
import uo.ri.cws.application.persistence.mechanic.MechanicGateway;

public class DeleteMechanic implements Command<Void>  {
	
	
	String idMechanic;

	public DeleteMechanic(String idMechanic) {
		this.idMechanic=idMechanic;
	}


	@Override
	public Void execute() throws BusinessException {
		MechanicGateway mg = PersistenceFactory.forMechanic();
		mg.remove(idMechanic);
		return null;
	}
}
