package uo.ri.cws.application.ui.manager.action;


import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.commands.DeleteMechanic;

public class DeleteMechanicAction implements Action {

	

	@Override
	public void execute() throws BusinessException {
		String idMechanic = Console.readString("Type mechanic id "); 
		MechanicDto mdto = new MechanicDto();
		mdto.id=idMechanic;
		DeleteMechanic dm = new DeleteMechanic(mdto);
		dm.execute();
		Console.println("Mechanic deleted");
	}

}
