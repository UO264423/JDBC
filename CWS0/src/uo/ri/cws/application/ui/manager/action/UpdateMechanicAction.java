package uo.ri.cws.application.ui.manager.action;



import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.commands.UpdateMechanic;

public class UpdateMechanicAction implements Action {


	@Override
	public void execute() throws BusinessException {
		
		// Get info
		MechanicDto mdto = new MechanicDto();
		mdto.id = Console.readString("Type mechahic id to update"); 
		mdto.name = Console.readString("Name"); 
		mdto.surname = Console.readString("Surname");
		UpdateMechanic um = new UpdateMechanic(mdto);
		um.execute();
		
		// Print result
		Console.println("Mechanic updated");
	}

}
