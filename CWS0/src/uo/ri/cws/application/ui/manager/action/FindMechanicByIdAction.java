package uo.ri.cws.application.ui.manager.action;



import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.crud.MechanicCrudServiceImpl;

public class FindMechanicByIdAction implements Action {

	
	
	@Override
	public void execute() throws BusinessException {
		// Get info
		
		String idMechanic = Console.readString("Enter id"); 
		
		MechanicCrudServiceImpl mcsi = new MechanicCrudServiceImpl();
		mcsi.findMechanicById(idMechanic);
	}
}
