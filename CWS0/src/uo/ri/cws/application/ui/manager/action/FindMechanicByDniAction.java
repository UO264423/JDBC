package uo.ri.cws.application.ui.manager.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.crud.MechanicCrudServiceImpl;

public class FindMechanicByDniAction implements Action{
	
	
	@Override
	public void execute() throws BusinessException {
		// Get info
		
		String dniMechanic = Console.readString("Enter dni"); 
		
		MechanicCrudServiceImpl mcsi = new MechanicCrudServiceImpl();
		mcsi.findMechanicByDni(dniMechanic);
	}
}
