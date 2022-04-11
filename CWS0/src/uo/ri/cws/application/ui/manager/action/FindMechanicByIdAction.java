package uo.ri.cws.application.ui.manager.action;



import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.cws.application.business.BusinessException;
import uo.ri.cws.application.business.mechanic.MechanicDto;
import uo.ri.cws.application.business.mechanic.crud.FindMechanicById;

public class FindMechanicByIdAction implements Action {

	
	
	@Override
	public void execute() throws BusinessException {
		// Get info
		MechanicDto mdto = new MechanicDto();
		mdto.id = Console.readString("Enter id"); 
		
		FindMechanicById fmbi= new FindMechanicById(mdto);
		mdto = fmbi.execute();
	}
}
