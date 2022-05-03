package uo.ri.cws.application.ui.manager.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.BusinessFactory;
import uo.ri.cws.application.persistence.PersistenceException;

public class FindMechanicByDniAction implements Action{
	
	
	@Override
	public void execute() throws BusinessException, PersistenceException {
		// Get info
		
		String dniMechanic = Console.readString("Enter dni"); 
		
		BusinessFactory.forMechanicCrudService().findMechanicByDni(dniMechanic);
	}
}
